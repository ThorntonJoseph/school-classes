`include "/gaia/class/student/thorntjl/csc137/project4/cla8bit.v"
module combine(
input clock,reset,start,mode,//clock,reset,start,mode
input [7:0] a,b,c,d,
output reg [7:0] result,
output done,
output cso

);
wire [4:0] cs;
assign cso=cs[1];
wire [7:0] o1,o2,o3,answer;
wire ovf;
controlunit c1(clock,reset,start,mode,cs);
mux m1(cs[3],d,o2,o3);
mux m2(cs[2],b,c,o2);
complimentaddsub add1(cs[0],cs[0],result,o2,answer,ovf);
mux m3(cs[1],a,answer,o1);
assign done=cs[4];

//register
always@ (posedge clock,posedge reset)
begin	
	if (reset==1)
		result=0;
	else
		result=o1;
	
end 
endmodule



module controlunit(
input  clock,reset,start,mode,
output reg [4:0] cs //m,s0,s1,s2,done
);
parameter A=2'b00,
B=2'b01,
C=2'b10,
D=2'b11;
reg [1:0] current_state,next_state;
always@* 

begin
	casex (current_state)
	A: if(start==1'b0) 
		next_state=A;
	else 
		next_state=B;

	B: 	next_state=C;

	C:	next_state=D;

	D:	next_state=D;
endcase
end
//OG
always@*
begin
	casex (current_state)
	A:	cs=5'b00000;
	
	B: if(mode==1)
		cs=5'b01011;
	else 
		cs=5'b01010;
	
	C:if(mode==1)
		cs=5'b01110;
	else 
		cs=5'b01111;
	
	D: 	cs=5'b10111;
	
	
endcase
end
//flip flop
always@ (posedge clock,posedge reset)
begin	
	if (reset==1)
		current_state<=A;
	else
		current_state=next_state;
end 
assign state=current_state;
endmodule


module mux(
input s,
input [7:0] a,b,
output reg [7:0] o
);
always@*
begin 
if (s==1'b0)
	o=a;
else
	o=b;
end
endmodule	
