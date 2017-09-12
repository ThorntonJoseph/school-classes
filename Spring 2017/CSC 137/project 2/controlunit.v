module controlunit(
input  clock,reset,start,mode,
output reg [5:0] cs //m,s0,s1,s2,done,e,
);
parameter A=3'b000,
B=3'b001,
C=3'b010,
D=3'b011,
F=3'b100;
reg [2:0] current_state,next_state;
always@* 
begin
	casex (current_state)
	A: if(start==1'b0) 
		next_state=A;
	else 
		next_state=B;

	B: 	next_state=C;

	C:	next_state=D;

	D:	next_state=F;

	F:	next_state=F;
endcase
end
//OG
always@*
begin
	casex (current_state)
	A:if(start==0)
		cs=6'b000000;
	else 
		cs=6'b100000;
	
	B: if(mode==1)
		cs=6'b101011;
	else 
		cs=6'b101010;
	
	C:if(mode==1)
		cs=6'b101110;
	else 
		cs=6'b101111;
	
	D: 	cs=6'b100111;
	F: 	cs=6'b010000;
	
	
endcase
end
//flip flop
always@ (posedge clock,reset)
begin	
	if (reset==1)begin
		current_state<=A;
		//$display("executed");
	end else
		current_state<=next_state;
//$display("%d %b",$time,current_state);
end 
//assign state=current_state;
endmodule
	
