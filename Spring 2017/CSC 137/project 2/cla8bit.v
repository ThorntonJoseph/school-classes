
module cla8bit(
input ci,
input [7:0] a,b,
output c6,c7,
output [7:0] s
);
wire [7:0] cs;
cla2bit cla1(ci,a[1:0],b[1:0],cs[0],cs[1],s[1:0]);
cla2bit cla2(cs[1],a[3:2],b[3:2],cs[2],cs[3],s[3:2]);
cla2bit cla3(cs[3],a[5:4],b[5:4],cs[4],cs[5],s[5:4]);
cla2bit cla4(cs[5],a[7:6],b[7:6],cs[6],cs[7],s[7:6]);
assign c6=cs[6];
assign c7=cs[7];
endmodule

module cla2bit(
input ci,
input [1:0] a,b,
output c0,cn,
output [1:0] s
);
wire [1:0] p,g,c;
pgu p1(a,b,p,g);
cgu c1(ci,p,g,c);
au a1(ci,p,c,s);
assign c0=c[0];
assign cn=c[1];
endmodule

module cgu(
input ci,
input [1:0] p,g,
output [1:0] c
);
wire [3:0] r;
assign r[0] = p[0]|g[0];
assign r[1] = g[0]|ci;
assign c[0] = r[0]&r[1];
assign r[2] = ci&p[0]&p[1];
assign r[3] = p[1]&g[0];
assign c[1] = g[1]|r[2]|r[3];
endmodule

module pgu(
input [1:0] a,b,
output [1:0] p,g
);
xlogic x1(a[0],b[0],p[0]);
xlogic x2(a[1],b[1],p[1]);
and a1(g[0],a[0],b[0]);
and a2(g[1],a[1],b[1]);
endmodule

module xlogic(
input a,b,
output f
);
//xor logic pos implimented 
wire o1, o2, o3, o4;
nor nor1(o1,a,b);
not n1(o2,a);
not n2(o3,b);
nor nor2(o4,o2,o3);
nor nor3(f,o4,o1);
endmodule

module au(
input ci,
input [1:0] p,c,
output [1:0] s
);
assign s[0]=ci^p[0];
assign s[1]=c[0]^p[1];
endmodule

module complimentaddsub(
input ci,m,
input [7:0] a,b,
output [7:0] answer,
output ovf
);
wire [7:0] bi;
wire c6,c7;

inverter inv1(b,m,bi);
cla8bit cla8(ci,a,bi,c6,c7,answer);
xlogic xlog6(c6,c7,ovf);
endmodule

module inverter(
input [7:0] invert,
input m,
output reg [7:0] inverted
);
reg [7:0] i;
always@*
for(i=8'b0;i<8'b1000;i=i+1'b1)begin
if(m==1)begin
	inverted[i]=~invert[i];
end else begin
	inverted[i]=invert[i];
end
end
endmodule
	



