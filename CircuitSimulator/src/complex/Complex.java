package complex;

import java.text.DecimalFormat;

public class Complex {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
    	if (this.equals(new Complex(Double.POSITIVE_INFINITY,0.0))) return "inf";
    	DecimalFormat df = new DecimalFormat("#.###");
    	String roundIm = df.format(im);
    	String roundRe = df.format(re);
    
        if (im == 0) return roundRe + "";
        if (re == 0) return roundIm + "i";
        if (im <  0) 
        	return roundRe + roundIm + "i";

        return roundRe + " + " + roundIm + "i";
    }

    // return abs/modulus/magnitude
    public double abs() {
        return Math.hypot(re, im);
    }

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        
        if (a.equals(new Complex(Double.POSITIVE_INFINITY,0))||b.equals(new Complex(Double.POSITIVE_INFINITY,0)))
        	return new Complex(Double.POSITIVE_INFINITY,0); // plus with positive inf
        
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        
        if (a.equals(new Complex(0,0))||b.equals(new Complex(0,0))) 
        	return new Complex(0,0); // multiple with 0
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // return a new object whose value is (this * alpha)
    public Complex scale(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }


    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }
    
    // return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        if (b.equals(new Complex(0.0,0.0))) return new Complex(Double.POSITIVE_INFINITY,0.0);
        if (b.equals(new Complex(Double.POSITIVE_INFINITY,0.0))) return new Complex(0.0,0.0);
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }


    // a static version of plus
    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    // See Section 3.3.
    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complex that = (Complex) x;
        return (this.re == that.re) && (this.im == that.im);
    }
}
    
