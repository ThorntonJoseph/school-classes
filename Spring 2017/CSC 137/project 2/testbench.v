`include "/gaia/class/student/thorntjl/csc137/project4/circularlogic.v"
module proj4test();
reg clock,reset,start,mode;//clock,reset,start,mode
reg [7:0] a,b,c,d;
wire [7:0] result;
wire done;
combine c1(clock,reset,start,mode,a,b,c,d,result,done);
initial begin
clock=1;
reset=1;
start=0;
clock=0;
#10 reset=0;//end
end
always
begin
#5 clock=~clock;
end
initial begin
#5 reset=1;
#5 reset=0;
start=0;
start=1;a=8'h01;b=8'h02;c=8'hFF;d=8'hFE;mode=1'b0;$display("a=%8h  b=%8h  c=%8h  d=%8h ",a,b,c,d);
#60 start=0;
#5 reset=1;
#5 reset=0;

start=1;a=8'hFE;b=8'h01;c=8'h01;d=8'h04;mode=1'b1;$display("a=%8h  b=%8h  c=%8h  d=%8h ",a,b,c,d);
#60 start=0;
#5 reset=1;
#5 reset=0;

start=1;a=8'h01;b=8'hFF;c=8'hFF;d=8'hFF;mode=1'b0;$display("a=%8h  b=%8h  c=%8h  d=%8h ",a,b,c,d);
#60 start=0;
#5 reset=1;
#5 reset=0;

start=1;a=8'hFF;b=8'h01;c=8'hFF;d=8'h01;mode=1'b1;$display("a=%8h  b=%8h  c=%8h  d=%8h ",a,b,c,d);
#60 start=0;
#5 reset=1;
#5 reset=0;

#60 $finish;
end

initial
$monitor ("%2d  %8h  %b",$stime,result,done);
endmodule
