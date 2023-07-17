class Stack<T>{
	private a:T[];
	private index:number = -1;
	public constructor(a:T[]){
		this.a = a;
	}
	
	private isFull():boolean{
		return this.index == 9;
	}
	
	private isEmpty():boolean{
		return this.index == 0;
	}
	
	
	public push(ele:T):void{
		if(!this.isFull()){
			this.a[++this.index] = ele;
		}else{
			console.log("Stack overflow");
		}
	}
	
	public pop():void{
		if(!this.isEmpty()){
			console.log(this.a[this.index--]);;
		}else{
			console.log("Stack underflow");
		}
	}
	
}

var s = new Stack<number>(new Array(3));
s.push(10);
s.push(90);
s.pop();
s.pop();