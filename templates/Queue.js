var Queue = /** @class */ (function () {
    function Queue(a) {
        this.front = -1;
        this.rear = -1;
        this.a = a;
    }
    Queue.prototype.isFull = function () {
        return (this.rear > this.a.length) || (this.rear == this.a.length);
    };
    Queue.prototype.isEmpty = function () {
        return (this.a.length <= 0) || ((this.front == -1) || (this.front > this.rear));
    };
    Queue.prototype.enqueue = function (ele) {
        if (!this.isFull()) {
            if (this.front == -1)
                this.front = 0;
            this.rear++;
            this.a[this.rear] = ele;
        }
        else {
            console.log("Queue is Full");
        }
    };
    Queue.prototype.dequeue = function () {
        if (!this.isEmpty())
            console.log(this.a[this.front++]);
        else {
            console.log("Queue is Empty");
        }
    };
    Queue.prototype.printQueue = function () {
        for (var i = this.front; i < this.rear; i++)
            console.log(this.a[i]);
    };
    return Queue;
}());
var q = new Queue(new Array(4));
q.enqueue(5);
console.log(q.front + "  " + q.rear);
q.enqueue(50);
console.log(q.front + "  " + q.rear);
q.enqueue(500);
console.log(q.front + "  " + q.rear);
//q.dequeue();
//q.dequeue();
console.log(q.front + "  " + q.rear);
q.enqueue(50000);
console.log(q.front + "  " + q.rear);
q.enqueue(500000);
q.printQueue();
console.log(q.front + "  " + q.rear + "\n" + q.a);
