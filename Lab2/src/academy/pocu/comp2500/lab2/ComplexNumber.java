package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public boolean isReal() {
        return this.imaginary == 0.0;
    }

    public boolean isImaginary() {
        return this.real == 0.0;
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(this.real, this.imaginary * -1);
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        double real = this.real * num.real - this.imaginary * num.imaginary;
        double imaginary = this.real * num.imaginary + this.imaginary * num.real;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber divide(ComplexNumber num) {
        double denominator = num.real * num.real + num.imaginary * num.imaginary;
        double real = (this.real * num.real + this.imaginary * num.imaginary) / denominator;
        double imaginary = ((-1 * this.real * num.imaginary) + this.imaginary * num.real) / denominator;
        return new ComplexNumber(real, imaginary);
    }
}
