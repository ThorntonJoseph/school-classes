module inverter(
output reg [7:0] e,
input  [7:0] b,
input m
);

// inverter
always@(*)
begin
if (m== 1'b1)
e = ~b;
else
e = b;
end
endmodule