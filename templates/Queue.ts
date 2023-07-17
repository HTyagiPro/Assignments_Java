class Queue<T>{
	private a:T[];
	private front:number = -1;
	private rear:number = -1;
	public constructor(a:T[]){
		this.a = a;
	}

	private isFull():boolean{
		return (this.rear > this.a.length) || (this.rear == this.a.length);

	}
	
	private isEmpty():boolean{
		return (this.a.length <=0) || ((this.front == -1) || (this.front > this.rear)); 
	}


	public enqueue(ele:T):void{
		if(!this.isFull()){
			if(this.front == -1)
				this.front =0;
			this.rear++;
			this.a[this.rear] = ele;
		}else{
			console.log("Queue is Full");
		}
	}


	public dequeue():void{
		if(!this.isEmpty())
			console.log(this.a[this.front++]);
	else{
			console.log("Queue is Empty");
		}

	}
	public printQueue():void{
		for(let i:number = this.front; i< this.rear;i++)
			console.log(this.a[i]);
	}
}

var q = new Queue<number>(new Array(5));
q.enqueue(5);
//console.log(q.front+"  "+q.rear);
q.enqueue(50);
//console.log(q.front+"  "+q.rear);
q.enqueue(500);
//console.log(q.front+"  "+q.rear);
//q.dequeue();
//q.dequeue();
//console.log(q.front+"  "+q.rear);
q.enqueue(50000);
//console.log(q.front+"  "+q.rear);
q.enqueue(500000);
q.printQueue();
