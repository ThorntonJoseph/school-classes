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
