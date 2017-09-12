`include "/gaia/class/student/thorntjl/csc137/project4/controlunit.v"
module proj4test();
reg clock,reset,start,mode;//clock,reset,start,mode
wire [4:0] cs;
wire [2:0] state;

controlunit c1(clock,reset,start,mode,cs,state);
initial begin
clock=0;
reset=1;
start=0;
#10 reset=0;//end
end
always
begin
 #100 clock=~clock;
end
initial begin
start=0;
start=1;mode=0;$display("in: %b  %b %b   %b",start,mode,reset,state);
#1000 start=0;
reset=1;
#100 reset=0;
start=1;mode=1;$display("in: %b  %b  %b   %b",start,mode,reset,state);
reset=1;
reset=0;
#1000 start=0;
#1000 $finish;
end

initial
$monitor ("%b  %5b %b  %b    %b",clock,cs,reset,start,state);
endmodule
