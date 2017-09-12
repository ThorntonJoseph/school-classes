module proj1c
(
input x,y,z,
output f1,f2,r
);
assign f1 = x|y; 
assign f2 = ~y|z;
assign r = f1&f2;
endmodule
