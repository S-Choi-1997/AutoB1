const [N, input] = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const machines = +N;

const losses = input
  .split(' ')
  .map(val => BigInt(val))
  .sort((a, b) => (a < b ? -1 : 1));

let answer = machines % 2 === 0 ? 0 : losses.pop();
let head = 0;
let tail = losses.length - 1;

while (head < tail) {
  if (losses[head] + losses[tail] > answer) answer = losses[head] + losses[tail];
  head += 1;
  tail -= 1;
}

console.log(answer.toString());