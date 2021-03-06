/**
 * B-I-N-G-O
 *
 * A Bingo card contain 25 squares arranged in a 5x5 grid (five columns
 * and five rows). Each space in the grid contains a number between 1
 * and 75. The center space is marked "FREE" and is automatically filled.
 *
 * As the game is played, numbers are drawn. If the player's card has
 * that number, that space on the grid is filled.
 *
 * A player wins BINGO by completing a row, column, or diagonal of filled
 * spaces.1
 *
 * Your job is to complete the function that takes a bingo card and array
 * of drawn numbers and return 'true' if that card has achieved a win.
 *
 * A bingo card will be 25 element array. With the string 'FREE' as the
 * center element (index 12). Although developers are unscrupulous, they
 * will pass valid data to your function.
 */

function checkForBingo (bingoCard, drawnNumbers) {
  // this code for debug purposes, you can remove.
  // console.log('Drawn Numbers: ' + JSON.stringify(drawnNumbers));

  let size = Math.sqrt(bingoCard.length);

  // size = parseInt(size, 10);

  let rows = new Array(size).fill(0);
  let cols = new Array(size).fill(0);
  let diags = new Array(2).fill(0);

  for (let i=0; i<bingoCard.length; i++) {
    let row = Math.floor(i/size);
    let col = i % size;

    if (bingoCard[i] == 'FREE' || containsNum(drawnNumbers, bingoCard[i])) {
      rows[row]++;
      cols[col]++;

      if (row == col) {
        diags[0] += 1;
      }

      if (row + col == size - 1) {
        diags[1] += 1;
      }
    }
  }

  return containsNum(rows, size) || containsNum(cols, size) || containsNum(diags, size);
}

function containsNum(array, num) {
  for (let i=0; i < array.length; i++) {
    if (array[i] == num) {
      return true;
    }
  }
  return false;
}

module.exports = checkForBingo;

// here are some samples

// this should return true with diagonal + free
let x = checkForBingo(
  [
    8, 29, 35, 54, 65,
    13, 24, 44, 48, 67,
    9, 21, 'FREE', 59, 63,
    7, 19, 34, 53, 61,
    1, 20, 33, 46, 72
  ],
  [
    8, 24, 53, 72
  ]
);

console.log(x);

// this should return false
let y = checkForBingo(
  [
   8, 29, 35, 54, 65,
   13, 24, 44, 48, 67,
   9, 21, 'FREE', 59, 63,
   7, 19, 34, 53, 61,
   1, 20, 33, 46, 72
  ],
  [
    1, 33, 53, 65, 29, 75
  ]
);

console.log(y);

let z = checkForBingo(
  [
   8, 29, 35, 54, 65,
   13, 24, 44, 48, 67,
   9, 21, 'FREE', 59, 63,
   7, 19, 34, 53, 61,
   1, 20, 33, 46, 72
  ],
  [
    1, 19, 48, 65, 29, 75
  ]
);

console.log(z);
