/**
 * @param {number[]} arr
 * @return {number}
 */
var fixedPoint = function(arr) {
    var flag = 0;
    for(var i =0;i<arr.length;i++)
        {
            if(i == arr[i])
                {
                    return i;
                }
        }
    if(flag == 0)
        {
            return -1;
        }
};