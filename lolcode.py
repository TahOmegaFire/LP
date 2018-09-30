import re

#TODO: Declared variable checking, variable assignation, conditionals, loops

vOCRegex = r'([A-Z|a-z](?:\w|\_)*|\d+)' #Regex for detecting either variables or numeric constants
oVOCRegex = re.compile(vOCRegex)
exprRegex = re.compile(r'(SUM|DIFF|PRODUKT|QUOSHUNT|MOD)? OF (.+) AN (.+)')
varDeclRegex = re.compile(r'(I HAS A [A-Z|a-z]\w*)\s*(?:ITZ (.+))?')
expVISRegex=re.compile(r'((VISIBLE|GIMMEH) (.+))') #GIMMEH NO ES LO MISMO QUE EL VISIBLE CAMBIAR
loopRegex=re.compile(r'IM IN YR ([A-Z|a-z](?:\w|\_)*) (?:UPPIN|NERFIN) YR ([A-Z|a-z](?:\w|\_)*) (?:TIL|WHILE) (.+)')
loopERegex = re.compile(r'IM OUTTA YR (.+)')
condOpRegex = re.compile(r'(?:(?:BIGGR|SMALLR|BOTH|EITHER) OF|BOTH SAEM|DIFFRINT|NOT) (.*)')
expRegular=[exprRegex,varDeclRegex,expVISRegex]
loopLines = list()
loopNames = list()
condLines = list()

nLoop = 0
pBeg = False
pEnd = False

def CheckExpr(sLine): #Group 2 is first operand, group 3 is the rest
	eMatch=None
	if re.match(expRegular[0],sLine):
		eMatch = re.match(expRegular[0], sLine)
		num=0
	elif re.match(expRegular[1],sLine):
		eMatch = re.match(expRegular[1], sLine)
		num=1
	elif re.match(expRegular[2],sLine):
		eMatch = re.match(expRegular[2], sLine)
		num=2
	if eMatch is not None:
		print(eMatch.groups())
		if (eMatch.group(1)==sLine):
			return True
		if (CheckExpr(eMatch.group(2)) is False):
			return False
		if num==0:
			if CheckExpr(eMatch.group(3)) is False:
				return False
	else :
		if re.match(oVOCRegex,sLine).group(1)!=sLine:
			return False
	return True

def CheckCond(nLine, fL):
	c = re.match(condOpRegex, fL[nLine])
	if c:
		if fL[nLine + 1] == 'O RLY?' and fL[nLine + 2] == 'YA RLY':
			nnLine = 0
			for index in range(nLine + 2, len(fL)):
				if fL[index] == 'NO WAI':
					if nnLine == 0:
						nnLine = index
					else:
						print(fL[nLine] + ' | Error')
						return
				elif fL[index] == 'OIC' and nnLine != 0:
					condLines.append(nLine + 1)
					condLines.append(nLine + 2)
					condLines.append(nnLine)
					condLines.append(index)
					return
				elif re.match(condOpRegex, fL[index]):
					CheckCond(index, fL)
		print(fL[nLine] + ' | Error')

def Iter(line, curL, fL):
	global pBeg
	global pEnd
	global nLoop
	global loopNames
	global loopLines
	if not pBeg and line != 'HAI':
		print(line + ' | Code has not correctly begun\n')
		#continue
		return

	elif line == 'HAI':
		print(line + ' | HAJIMERUZO\n')
		pBeg = True
		pEnd = False
		#continue
		return

	if pEnd == True and line != '':
		print(line + ' | ERROR: Code post script end')
		#continue
		return

	elif line == 'KTHXBYE':
		print(line + ' | BAI\n')
		pEnd = True
		pBeg = False
		return

	m = re.match(loopRegex, line)
	if m is not None:
		h = re.match(condOpRegex, m.group(3))
		if h:
			loopN = 0
			for j in range(curL, len(fL)):
				e = re.match(loopERegex, fL[j])
				l = re.match(loopRegex, fL[j])
				if l and l.group(1) != m.group(1):
					loopN += 1
				elif e:
					if e.group(1) != m.group(1):
						loopN -= 1
						continue
					elif e.group(1) == m.group(1) and loopN == 0:
						print(line + ' | Loop begin')
						loopNames.append(m.group(1))
						nLoop += 1
						return
			print(line + ' | Error')
			return

	
	c = re.match(condOpRegex, line)
	if c:
		CheckCond(curL, fL)
		return

	if line != 'OIC' and CheckExpr(line):
		print(line + ' | Expr\n')
		return
	else:
		print(line + ' | Error\n')

with open('code.lc') as fIn:
	fileLines = list()
	for iLine in fIn:
		iLine = iLine.strip()
		fileLines.append(iLine)
	for i in range(len(fileLines)):
		if i in condLines:
			print(fileLines[i] + ' | Cond')
			continue
		e = re.match(loopERegex, fileLines[i])
		if e is not None and nLoop > 0 and nLoop - 1 < len(loopNames) and loopNames[nLoop - 1] == e.group(1):
			print(fileLines[i] + ' | Loop end')
			loopNames.pop()
			nLoop -= 1
			continue
		Iter(fileLines[i], i, fileLines)
				
