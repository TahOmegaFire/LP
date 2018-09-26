import re

#TODO: Declared variable checking, variable assignation, conditionals, loops

vOCRegex = r'(?:[A-Z|a-z]\w*|\d+)' #Regex for detecting either variables or numeric constants
oVOCRegex = re.compile(vOCRegex)
#exprRegex = re.compile(r'(((SUM|DIFF|PRODUKT|QUOSHUNT|MOD|BIGGR|SMALLR|BOTH|EITHER) OF )(([A-Z]+ OF .+ AN .+)|'+vOCRegex+r')+ AN (([A-Z]+ OF .+ AN .+)|'+vOCRegex+')+)') #TODO: Rest of operators holy shit that was long
exprRegex = re.compile(r'(SUM|DIFF|PRODUKT|QUOSHUNT|MOD) OF ('+vOCRegex+r'|.+) (.+)')
varDeclRegex = re.compile(r'(^(I HAS A ([A-Z|a-z]\w*))( ITZ '+vOCRegex+r')?)')

'''def CheckExpr(sLine): #Group 4 is first operand, group 6 is second
    if re.match(exprRegex, sLine) is not None:
        fOp = re.match(exprRegex, sLine).group(4)
        sOp = re.match(exprRegex, sLine).group(6)
        if fOp != re.match(vOCRegex, fOp).group():
            if re.match(exprRegex, fOp) is None:
                return False
            else:
                if not CheckExpr(fOp):
                    return False

        elif sOp != re.match(vOCRegex, sOp).group():
            if re.match(exprRegex, fOp) is None:
                return False
            else:
                if not CheckExpr(fOp):
                    return False
        return True
'''
def CheckExpr(sLine, fOp, nOfAnd): #Group 2 is first operand, group 3 is the rest
    print(nOfAnd)
    nOfAnd -= 1
    if nOfAnd < 0:
        return False
    print('Line: ' + sLine)
    eMatch = re.match(exprRegex, sLine)
    if not fOp:
        vMatch = re.match(oVOCRegex, sLine)
    if eMatch is not None:
        print('Matched expression')
        print(eMatch.groups())
        if re.match(exprRegex, eMatch.group(2) + ' ' + eMatch.group(3)) is not None:
            return CheckExpr(eMatch.group(2) + ' ' + eMatch.group(3), False, nOfAnd + 1)
        if re.match(oVOCRegex, eMatch.group(2)) is not None:
            #print(eMatch.group(3)[3:] + ' | sss')
            return CheckExpr(eMatch.group(3)[3:], False, nOfAnd + 1)
        else:
            return False
    elif not fOp and vMatch is not None:
        print('Matched variable')
        print(vMatch.group())
        print(sLine + ' |')
        if vMatch.group() == sLine:
            return True
        else:
            return CheckExpr(vMatch.group()[3:], False, nOfAnd)
    else:
        return False
        

pBeg = False
pEnd = False
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

        if re.match(varDeclRegex, line) is not None:
            if re.match(varDeclRegex, line).group() == line:
                print(line + ' | Var decl\n')
            else:
                print(line + ' | Syntax error\n')
            continue

        elif re.match(exprRegex, line):
            if CheckExpr(line, True, 2):
                print(line + ' | Expr\n')
                continue
            else:
                print(line + ' | Error')

        
