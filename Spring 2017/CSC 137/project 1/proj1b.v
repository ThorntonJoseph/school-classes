module proj1b(
input x,y,z,
output f
);
wire out1, out2, out3;
nor o1(out1,x,y);
not n1(out2,y);
nor o2(out3,out2,z);
nor a1(f,out1,out3);
endmodule
