import re

#TODO: Declared variable checking, variable assignation, conditionals, loops

vOCRegex = r'([A-Z|a-z]?\w*\_*\w*|\d+)' #Regex for detecting either variables or numeric constants
oVOCRegex = re.compile(vOCRegex)
#exprRegex = re.compile(r'(((SUM|DIFF|PRODUKT|QUOSHUNT|MOD|BIGGR|SMALLR|BOTH|EITHER) OF )(([A-Z]+ OF .+ AN .+)|'+vOCRegex+r')+ AN (([A-Z]+ OF .+ AN .+)|'+vOCRegex+')+)') #TODO: Rest of operators holy shit that was long
exprRegex = re.compile(r'(SUM|DIFF|PRODUKT|QUOSHUNT|MOD)? OF (.+) AN (.+)')
varDeclRegex = re.compile(r'(I HAS A [A-Z|a-z]\w*) ITZ (.+)')
expVISRegex=re.compile(r'((VISIBLE|GIMMEH) (.+))') #GIMMEH NO ES LO MISMO QUE EL VISIBLE CAMBIAR
expRegular=[exprRegex,varDeclRegex,expVISRegex]
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
		if (CheckExpr(eMatch.group(2)) is False):
			return False
		if num==0:
			if CheckExpr(eMatch.group(3)) is False:
				return False
	else :
		if re.match(oVOCRegex,sLine).group(1)!=sLine:
			return False
	return True
pBeg = False
pEnd = False
eMatch = re.match(varDeclRegex,"I HAS A n")
if eMatch is not None:
	print (eMatch.groups())
else:
	print("lala")
with open('code.lc') as fIn:
	for line in fIn:
		line = line.strip()
		if not pBeg and line != 'HAI':
			print(line + ' | Code has not correctly begun\n')
			continue

		elif line == 'HAI':
			print(line + ' | HAJIMERUZO\n')
			pBeg = True
			continue

		if pEnd == True and line != '':
			print(line + ' | ERROR: Code post script end')
			continue

		elif line == 'KTHXBYE':
			print(line + ' | BAI\n')
			pEnd = True
			continue
		#if re.match(expRegular[0],line) is not None:
			#print(re.match(expRegular[0],line).groups())

		if CheckExpr(line):
			print(line + ' | Expr\n')
			continue
		else:
			print(line + ' | Error\n')
