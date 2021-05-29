package complex;

import java.text.DecimalFormat;

public class Complex {
    private final double re;   // the real part
    private final double im;   // the imaginary part
    
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    @Override
    public String toString() {
    	if (this.equals(new Complex(Double.POSITIVE_INFINITY,0.0))) 
    		return "+inf";
    	if (this.equals(new Complex(Double.NEGATIVE_INFINITY,0.0))) 
    		return "-inf";
    	
    	
    	// Rounding number
    	DecimalFormat df = new DecimalFormat("#.###");
    	String roundIm = df.format(im);
    	String roundRe = df.format(re);
    	
    	// display
        if (im == 0) return roundRe + "";
        if (re == 0) return roundIm + "i";
        if (im <  0) 
        	return roundRe + roundIm + "i";

        return roundRe + " + " + roundIm + "i";
    }

    // return this + b
    public Complex plus(Complex b) {
        double real = this.re + b.re;
        double imag = this.im + b.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        double real = this.re - b.re;
        double imag = this.im - b.im;
        return new Complex(real, imag);
    }

    // return this * b
    public Complex times(Complex b) {
    	
    	//handle this times 0
    	if (b.equals(new Complex(0,0))||this.equals(new Complex(0,0))) return new Complex(0,0);
    	
        double real = this.re * b.re - this.im * b.im;
        double imag = this.re * b.im + this.im * b.re;
        return new Complex(real, imag);
    }

    // return this * alpha
    public Complex scale(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    public double re() { 
    	return re; 
    }
    public double im() { 
    	return im; 
    }

    // return 1/this
    public Complex reciprocal() {
    	//(a+bi) * (a-bi) = scale; 1/(a+bi) = (a-bi) / (a+bi)*(a-bi) = (a-bi)/scale
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }
    
    // return this/b
    public Complex divides(Complex b) {
        Complex a = this;
        // handle divide by INF        
        if (b.equals(new Complex(Double.POSITIVE_INFINITY,0.0))||b.equals(new Complex(Double.NEGATIVE_INFINITY,0.0))) return new Complex(0.0,0.0);
        
        //handle divide by 0
        if (b.equals(new Complex(0,0)))
        	if (this.re()<0) return new Complex(Double.NEGATIVE_INFINITY,0);
        	else return new Complex(Double.POSITIVE_INFINITY,0);
        
        // a/b = a * 1/b
        return a.times(b.reciprocal());
    }
    
    @Override
    public boolean equals(Object x) {
    	// if Object is null -> false
        if (x == null) return false;
        // if different class -> false
        if (this.getClass() != x.getClass()) return false;
        Complex that = (Complex) x;
        return (this.re == that.re) && (this.im == that.im);
    }
}
    
