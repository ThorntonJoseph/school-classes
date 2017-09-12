module proj1d
(
input x,y,z,
output reg f
);
always@(*)
begin
	case({x,y,z})
	3'b000: begin f=0; end
	3'b001: begin f=0; end
	3'b010: begin f=0; end
	3'b011: begin f=1; end
	3'b100: begin f=1; end
	3'b101: begin f=1; end
	3'b110: begin f=0; end
	3'b111: begin f=1; end
	default: begin f=0; end
	endcase
end
endmodule
