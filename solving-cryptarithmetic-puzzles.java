// Problem link - https://www.geeksforgeeks.org/solving-cryptarithmetic-puzzles/

static boolean solvePuzzle(Puzzle puzzle, String lettersToAssign) {
    if (lettersToAssign.isEmpty()) 
        return puzzleSolved(puzzle);
    for (int digit = 0; digit <= 9; digit++) // try all digits
    {
        if (assignLetterToDigit(lettersToAssign.charAt(0), digit)) {
            if (solvePuzzle(puzzle, lettersToAssign.substring(1)))
                return true;
            unassignLetterFromDigit(lettersToAssign.charAt(0), digit);
        }
}
    return false; 
}
