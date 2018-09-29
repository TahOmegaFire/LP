import re

#TODO: Declared variable checking, variable assignation, conditionals, loops

vOCRegex = r'([A-Z|a-z](?:\w|\_)*|\d+)' #Regex for detecting either variables or numeric constants
oVOCRegex = re.compile(vOCRegex)
#exprRegex = re.compile(r'(((SUM|DIFF|PRODUKT|QUOSHUNT|MOD|BIGGR|SMALLR|BOTH|EITHER) OF )(([A-Z]+ OF .+ AN .+)|'+vOCRegex+r')+ AN (([A-Z]+ OF .+ AN .+)|'+vOCRegex+')+)') #TODO: Rest of operators holy shit that was long
exprRegex = re.compile(r'(SUM|DIFF|PRODUKT|QUOSHUNT|MOD)? OF (.+) AN (.+)')
varDeclRegex = re.compile(r'(I HAS A [A-Z|a-z]\w*)\s*(?:ITZ (.+))?')
expVISRegex=re.compile(r'((VISIBLE|GIMMEH) (.+))') #GIMMEH NO ES LO MISMO QUE EL VISIBLE CAMBIAR
loopRegex=re.compile(r'IM IN YR ([A-Z|a-z](?:\w|\_)*) (?:UPPIN|NERFIN) YR ([A-Z|a-z](?:\w|\_)*) (?:TIL|WHILE) (.+)')
loopERegex = re.compile(r'IM OUTTA YR (.+)')
expRegular=[exprRegex,varDeclRegex,expVISRegex]
loopLines = list()
loopNames = list()

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

def Iter(line):
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
		#continue
		return
#if re.match(expRegular[0],line) is not None:
#print(re.match(expRegular[0],line).groups())

	m = re.match(loopRegex, line)
	if m is not None:
		loopNames.append(m.group(1))
		nList = list()
		loopLines.append(nList)
		nLoop += 1
		loopLines[nLoop - 1].append(line)
		return

	if CheckExpr(line):
		print(line + ' | Expr\n')
		return
	else:
		print(line + ' | Error\n')

def LoopHelper(loopLines, depth):
	print(loopLines[depth][0] + ' | Loop begin')
	
	length = len(loopLines[depth]) - 1
	for line in loopLines[depth][1:length]:
		l = re.match(loopRegex, line)
		if l is not None:
			print(l.groups())
			LoopHelper(loopLines, depth + 1)
			continue
		Iter(line)
	print(loopLines[depth][length] + ' | Loop end')


with open('code.lc') as fIn:
	for iLine in fIn:
		iLine = iLine.strip()
		if nLoop == 0:
			if len(loopLines) != 0:
				LoopHelper(loopLines, 0)
			Iter(iLine)

		else:
			loopLines[nLoop - 1].append(iLine)
			e = re.match(loopERegex, iLine)
			l = re.match(loopRegex, iLine)	
			if e is not None and loopNames[nLoop - 1] == e.group(1):
				loopNames.pop()
				#loopLines[nLoop - 1].pop()
				nLoop -= 1
				#print(loopLines[nLoop][0] + ' | Loop begin')
				#for lLine in loopLines[nLoop][1:]:
				#	Iter(lLine)
				#print(iLine + ' | Loop end')
				#del loopLines[nLoop]

			else:
				for name in loopNames:
					if e is not None and name == e.group(1):
						nLoop -= 1
						for lLine in loopLines[nLoop]:
							print(lLine + ' | Error')
			if l is not None:
				loopNames.append(l.group(1))
				nList = list()
				loopLines.append(nList)
				nLoop += 1
				loopLines[nLoop - 1].append(iLine)
				continue
