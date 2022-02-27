/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
    if (!s) return 0;
    let operator = '+';
    let currentNumber = 0, lastNumber = 0, result = 0;

    for (let i = 0; i < s.length; i += 1) {
	// build currentNumber if s[i] is still a number string
        if (isNum(s[i])) {
            currentNumber = (currentNumber * 10) + (s[i] - '0');
        }
		// Do different operations based on operator
        if (!isNum(s[i]) && s[i] !== ' ' || i === s.length - 1) {
            if (operator === '+' || operator === '-') {
                result += lastNumber;
                lastNumber = (operator === '+') ? currentNumber : -currentNumber;
            } else if (operator === '*') {
                lastNumber = lastNumber * currentNumber;
            }  else if (operator === '/') {
			// Math.floor of -1.5 is -2 (We want Math.ceil if negative)
                lastNumber = lastNumber < 0 ? Math.ceil(lastNumber / currentNumber) : Math.floor(lastNumber / currentNumber);
            }
            
			// At this point, s[i] cannot be anything but an operator, so set it. 
            operator = s[i];
            currentNumber = 0;
        }
    }
	
    result += lastNumber;
    return result;
};

const isNum = (str) => {
    return str >= '0' && str <= '9';
}