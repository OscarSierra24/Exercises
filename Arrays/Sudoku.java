class Sudoku {
  boolean sudoku2(char[][] grid) {
    HashSet<Character>[] rowMem = new HashSet[9]; // memory
    HashSet<Character>[] colMem = new HashSet[9]; // memory
    HashSet<Character>[] threeByThreeMem = new HashSet[9]; // memory

    for (int i = 0; i < 9; i++) {
      rowMem[i] = new HashSet<Character>();
      colMem[i] = new HashSet<Character>();
      threeByThreeMem[i] = new HashSet<Character>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (grid[i][j] == '.') {
          continue;
        }

        if (colMem[i].contains(grid[i][j])) {
          return false;
        } else {
          colMem[i].add(grid[i][j]);
        }

        if (rowMem[j].contains(grid[i][j])) {
          return false;
        } else {
          rowMem[j].add(grid[i][j]);
        }

        int threeByThreePos = (i / 3) * 3 + (j / 3);
        if (threeByThreeMem[threeByThreePos].contains(grid[i][j])) {
          return false;
        } else {
          threeByThreeMem[threeByThreePos].add(grid[i][j]);
        }
      }
    }

    return true;

  }
}