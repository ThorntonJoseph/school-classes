module proj1a(
input x,y,z,
output f
);
wire out1, out2, out3;
or o1(out1,x,y);
not n1(out2,y);
or o2(out3,out2,z);
and a1(f,out1,out3);
endmodule
