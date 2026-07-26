# Minesweeper

A terminal-based Minesweeper game built in Java. Coloured Unicode rendering, cascading cell reveal, configurable difficulty, and full input validation.

## Features

- **Three difficulty levels** — Easy (10×10, 10 mines), Medium (16×16, 40 mines), Expert (24×24, 99 mines)
- **Coloured ANSI output** — numbers gradient from green→orange→red by danger level, row/column labels in grey
- **Unicode board** — `◼` hidden cells, `·` for revealed empty, `*` for mines
- **Cascading reveal** — revealing a zero-adjacent cell recursively opens neighbours
- **Input validation** — non-numeric input caught cleanly, out-of-bounds coordinates rejected with a clear error
- **Replay loop** — play again prompt at game end without restarting the program

## How to run

```bash
# Compile
javac -d bin src/**/*.java src/*.java

# Run
java -cp bin App
```

## Project structure

```
src/
├── App.java                  # Entry point
├── board/
│   ├── Board.java            # Grid logic, mine placement, adjacent counts, flood-fill reveal
│   └── Cell.java             # Cell state (mine, revealed, adjacent count)
├── minesweeper/
│   └── Minesweeper.java      # Game loop, rendering, input handling, win/loss checks
└── util/
    └── Color.java            # ANSI escape code enum (8 colours including 256-colour orange)
```
