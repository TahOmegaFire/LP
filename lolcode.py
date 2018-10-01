import re

#TODO: Declared variable checking, variable assignation, conditionals, loops

vOCRegex = r'([A-Z|a-z]\w*\_*\w*|\d+)' #Regex for detecting either variables or numeric constants
oVOCRegex = re.compile(vOCRegex)
#exprRegex = re.compile(r'(((SUM|DIFF|PRODUKT|QUOSHUNT|MOD|BIGGR|SMALLR|BOTH|EITHER) OF )(([A-Z]+ OF .+ AN .+)|'+vOCRegex+r')+ AN (([A-Z]+ OF .+ AN .+)|'+vOCRegex+')+)') #TODO: Rest of operators holy shit that was long
exprRegex = re.compile(r'((?:(?:SUM|DIFF|PRODUKT|QUOSHUNT|MOD|BIGGR|SMALLR|BOTH|EITHER) OF)|(?:BOTH SAEM|DIFFRINT)) (.+) (AN) (.+)')
varDeclRegex = re.compile(r'(I HAS A) ([A-Z|a-z]\w*)\s?(?:(ITZ) (.+))?')
exprDRegex = re.compile(r'((?:(?:SUM|DIFF|PRODUKT|QUOSHUNT|MOD|BIGGR|SMALLR|BOTH|EITHER) OF)|(?:BOTH SAEM|DIFFRINT)) (.+) (AN) ((?:(?:(?:SUM|DIFF|PRODUKT|QUOSHUNT|MOD|BIGGR|SMALLR|BOTH|EITHER) OF)|(?:BOTH SAEM|DIFFRINT)) (?:.+) AN (?:.+))')
expVISRegex=re.compile(r'(VISIBLE) (.+)')
expGIMRegex=re.compile(r'(GIMMEH) ([A-Z|a-z]\w*)')
expReRegex=re.compile(r'([A-Z|a-z]\w*) (R) (.+)')
loopRegex=re.compile(r'(IM IN YR) ([A-Z|a-z]\w*) ((?:UPPIN|NERFIN) YR) ([A-Z|a-z]\w*) (TIL|WHILE) (.+)')
loopERegex = re.compile(r'(IM OUTTA YR) ([A-Z|a-z]\w*)')
expNOTRegex = re.compile(r'(NOT) (.+)')
condOpRegex = re.compile(r'(?:(?:BIGGR|SMALLR|BOTH|EITHER) OF|BOTH SAEM|DIFFRINT|NOT) (.*)')
condRegex = re.compile(r'(O RLY\?|YA RLY|NO WAI|OIC)')
expRegular=[exprDRegex,expReRegex,expVISRegex,expGIMRegex,varDeclRegex,loopRegex,loopERegex,condRegex,expNOTRegex]
colReg=['34','31','31','31','33','35','35','36','34']
loopLines = list()
loopNames = list()
condLines = list()
nLoop = 0
def ColoreaWithUs(linea):
	(eMatch,num)=detTypeOfExpr(linea)
	if eMatch is not None:
		if num==1:
			line="\033[0;m"+eMatch[0]+"\033[0;"+colReg[num]+"m "+eMatch[1]+"\033[0;m "+ColoreaWithUs(eMatch[2])
		elif num==2:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+ColoreaWithUs(eMatch[1])
		elif num==3:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+eMatch[1]
		elif num==4 and eMatch[2] is not None:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+eMatch[1]+"\033[0;"+colReg[num]+"m "+eMatch[2]+"\033[0;m "+ColoreaWithUs(eMatch[3])
		elif num==4 and eMatch[2] is None:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+eMatch[1]
		elif num==0:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+ColoreaWithUs(eMatch[1])+"\033[0;"+colReg[num]+"m "+eMatch[2]+"\033[0;m "+ColoreaWithUs(eMatch[3])
		elif num==7:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]
		elif num==5:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+eMatch[1]+"\033[0;"+colReg[num]+"m "+eMatch[2]+"\033[0;m "+eMatch[3]+"\033[0;"+colReg[num]+"m "+eMatch[4]+"\033[0;m "+ColoreaWithUs(eMatch[5])
		elif num==6:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+eMatch[1]
		elif num==8:
			line="\033[0;"+colReg[num]+"m"+eMatch[0]+"\033[0;m "+ColoreaWithUs(eMatch[1])
		return line
	else:
		return linea
def detTypeOfExpr(sLine):
	if re.match(expRegular[0],sLine):
		eMatch = re.match(expRegular[0], sLine)
		return (eMatch.groups(),0)
	elif re.match(exprRegex,sLine):
		eMatch = re.match(exprRegex,sLine)
		return (eMatch.groups(),0)
	elif re.match(expRegular[1],sLine):
		eMatch = re.match(expRegular[1], sLine)
		return (eMatch.groups(),1)
	elif re.match(expRegular[2],sLine):
		eMatch = re.match(expRegular[2], sLine)
		return (eMatch.groups(),2)
	elif re.match(expRegular[3],sLine):
		eMatch = re.match(expRegular[3], sLine)
		return (eMatch.groups(),3)
	elif re.match(expRegular[4],sLine):
		eMatch = re.match(expRegular[4], sLine)
		return (eMatch.groups(),4)
	elif re.match(expRegular[5],sLine):
		eMatch = re.match(expRegular[5], sLine)
		return (eMatch.groups(),5)
	elif re.match(expRegular[6],sLine):
		eMatch = re.match(expRegular[6], sLine)
		return (eMatch.groups(),6)
	elif re.match(expRegular[7],sLine):
		eMatch = re.match(expRegular[7], sLine)
		return (eMatch.groups(),7)
	elif re.match(expRegular[8],sLine):
		eMatch = re.match(expRegular[8], sLine)
		return (eMatch.groups(),8)
	return (None,-1)

def CheckExpr(sLine,fOp): #Group 2 is first operand, group 3 is the rest
	(eMatch,num)=detTypeOfExpr(sLine)
	if eMatch is not None and num!=7 and num!=6 and num!=5:
		eMatch=list(eMatch)
		fOp=False
		if (' '.join(pal for pal in eMatch if pal))!=sLine:
			return False
		if len(eMatch)==4 and eMatch[3] is not None:
			if CheckExpr(eMatch[3],fOp) is False:
				return False
		elif len(eMatch)==3 and eMatch[2] is not None:
			if CheckExpr(eMatch[2],fOp) is False:
				return False
		if CheckExpr(eMatch[1],fOp) is False:
			return False
	elif re.match(vOCRegex,sLine) is not None :
		if re.match(vOCRegex,sLine).group(1)!=sLine:
			return False
	if(fOp==True):
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
						return False
				elif fL[index] == 'OIC' and nnLine != 0:
					condLines.append(nLine + 1)
					condLines.append(nLine + 2)
					condLines.append(nnLine)
					condLines.append(index)
					return False
				elif re.match(condOpRegex, fL[index]):
					CheckCond(index, fL)

def Iter(line, curL, fL):
	global nLoop
	global loopNames
	global loopLines
	m = re.match(loopRegex, line)
	if m is not None:
		h = re.match(condOpRegex, m.group(6))
		if h:
			loopN = 0
			for j in range(curL, len(fL)):
				e = re.match(loopERegex, fL[j])
				l = re.match(loopRegex, fL[j])
				if l and l.group(2) != m.group(2):
					loopN += 1
				elif e:
					if e.group(2) != m.group(2):
						loopN -= 1
						continue
					elif e.group(2) == m.group(2) and loopN == 0:
						loopNames.append(m.group(2))
						nLoop += 1
						return True
			return False


	c = re.match(condOpRegex, line)
	if c:
		CheckCond(curL, fL)
		return True

	if line != 'OIC' and CheckExpr(line,True):
		return True
	else:
		return False

pBeg = False
pEnd = False
posBegAndEnd=[-1,-1]
numLine=0
lines=list()
with open('code.lc') as fIn:
	for line in fIn:
		line = line.strip()
		lines.append(line)
		if line == 'HAI' and posBegAndEnd[0]==-1:
			posBegAndEnd[0] = numLine
		elif line == 'KTHXBYE':
			posBegAndEnd[1] = numLine
		numLine+=1
for i in range(numLine):
	linea = False
	if (posBegAndEnd[0]>=0 and posBegAndEnd[1]>0) and (posBegAndEnd[0]<posBegAndEnd[1]):
		if (posBegAndEnd[0])<i and i<(posBegAndEnd[1]):
			if i in condLines:
				print(ColoreaWithUs(lines[i]))
				continue
			e = re.match(loopERegex, lines[i])
			if e is not None and nLoop > 0 and nLoop - 1 < len(loopNames) and loopNames[nLoop - 1] == e.group(2):
				print (ColoreaWithUs(lines[i]))
				linea = True
				loopNames.pop()
				nLoop -= 1
				continue
			linea=Iter(lines[i], i, lines)
			if linea!=True:
				linea=CheckExpr(lines[i],True)
		elif (posBegAndEnd[0])==i or i==(posBegAndEnd[1]):
			print("\033[0;32m"+lines[i]+"\033[0;m")
			continue
	if i<posBegAndEnd[0] or linea == False or i>posBegAndEnd[1]:
		print("\033[0;;41m"+lines[i]+"\033[0;m")
	else:
		print (ColoreaWithUs(lines[i]))
