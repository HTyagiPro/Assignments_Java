var Stack = /** @class */ (function () {
    function Stack(a) {
        this.index = -1;
        this.a = a;
    }
    Stack.prototype.isFull = function () {
        return this.index == 2;
    };
    Stack.prototype.isEmpty = function () {
        return this.index == 0;
    };
    Stack.prototype.push = function (ele) {
        if (!this.isFull()) {
            this.a[++this.index] = ele;
        }
        else {
            console.log("Stack overflow");
        }
    };
    Stack.prototype.pop = function () {
        if (!this.isEmpty()) {
            console.log(this.a[this.index--]);
            ;
        }
        else {
            console.log("Stack underflow");
        }
    };
    return Stack;
}());
var s = new Stack(new Array(3));
s.push(10);
s.push(90);
s.push(5);
s.push(15);
s.pop();
s.pop();
s.pop();
s.pop();
s.pop();
