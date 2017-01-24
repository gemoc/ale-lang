package interpreter

class TrigoServices {
	
	def static double cosinus(Double angle) {
		val t =  Math.cos((angle/360.0)*Math.PI*2)
		return Math.cos((angle/360.0)*Math.PI*2)
	}
	
	def static double sinus(Double angle) {
		return Math.sin((angle/360.0)*Math.PI*2)
	}
	
	def static double tan(Double angle) {
		return Math.tan((angle/360.0)*Math.PI*2)
	}
	
}