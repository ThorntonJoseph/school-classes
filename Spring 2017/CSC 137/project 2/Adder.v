module Adder
(
output [7:0] S,
output  c7, c6,
input  [7:0] A,E,
input m
);
wire [7:0] G,P;
wire c0,c1,c2,c3,c4,c5;
wire out1, out2, out3, out4, out5, out6, out7, out8, out9, out10, out11, out12;
wire Cin;

assign Cin = m;

// PG unit
and a1(G[0], A[0], E[0]);
xor x1(P[0], A[0], E[0]);

and a2(G[1], A[1], E[1]);
xor x2(P[1], A[1], E[1]);

and a3(G[2], A[2], E[2]);
xor x3(P[2], A[2], E[2]);

and a4(G[3], A[3], E[3]);
xor x4(P[3], A[3], E[3]);

and a5(G[4], A[4], E[4]);
xor x5(P[4], A[4], E[4]);

and a6(G[5], A[5], E[5]);
xor x6(P[5], A[5], E[5]);

and a7(G[6], A[6], E[6]);
xor x7(P[6], A[6], E[6]);

and a8(G[7], A[7], E[7]);
xor x8(P[7], A[7], E[7]);

//CG unit + Sum unit for the first 2 bit
and a9(out1, P[0], Cin);
or o1(c0, out1, G[0]);

and a10(out2, P[1], G[0]);
and a11(out3, P[1], P[0], Cin);
or o2(c1, out2, out3, G[1]);

xor x9(S[0], P[0], Cin);
xor x10(S[1], P[1], c0);

//CG unit + Sum unit for the second 2 bit
and a12(out4, P[2], c1);
or o3(c2, out4, G[2]);

and a13(out5, P[3], G[2]);
and a14(out6, P[3], P[2], c1);
or o4(c3, out6, out5, G[3]);

xor x11(S[2], P[2], c1);
xor x12(S[3], P[3], c2);

//CG unit + Sum unit for the third 2 bit
and a15(out7, P[4], c3);
or o5(c4, out7, G[4]);

and a16(out8, P[5], G[4]);
and a17(out9, P[5], P[4], c3);
or o6(c5, out9, out8, G[5]);

xor x13(S[4], P[4], c3);
xor x14(S[5], P[5], c4);

//CG unit + Sum unit for the last 2 bit
and a18(out10, P[6], c5);
or o7(c6, out10, G[6]);

and a19(out11, P[7], G[6]);
and a20(out12, P[7], P[6], c5);
or o8(c7, out11, out12, G[7]);

xor x15(S[6], P[6], c5);
xor x16(S[7], P[7], c6);

endmodule