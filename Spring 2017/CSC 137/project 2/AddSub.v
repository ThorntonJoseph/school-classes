`include "Inverter.v"
`include "Adder.v"
module AddSub(
input  [7:0] a,b,
input m,
output [7:0] s,
output  ovf
);
wire [7:0] e;
wire c6, c7;
assign ovf = c7 ^ c6;
// Add/subtract
Adder u1(s, c7, c6, a, e, m);

//inverter
inverter u2(e, b, m);
endmodule