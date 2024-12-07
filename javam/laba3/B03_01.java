public class Main {
    public static void main(String[] args) {
        ComplexNumber[] complexArray = {
            new ComplexNumber(1, 2),
            new ComplexNumber(3, 4),
            new ComplexNumber(5, 6)
        };

        System.out.println("Complex numbers:");
        for (ComplexNumber cn : complexArray) {
            System.out.println(cn);
        }

        ComplexNumber product = ComplexNumber.multiplyArray(complexArray);
        System.out.println("Product of all complex numbers: " + product);
    };
};


class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(ComplexNumber other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    @Override
    public String toString() {
        if (imaginary < 0) {
            return real + " - " + Math.abs(imaginary) + "i";
        } else {
            return real + " + " + imaginary + "i";
        }
    }

    @Override
    public boolean equals(Object obj) {
        ComplexNumber that = (ComplexNumber) obj;
        return Double.compare(that.real, real) == 0 && Double.compare(that.imaginary, imaginary) == 0;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public static ComplexNumber multiplyArray(ComplexNumber[] numbers) {
        ComplexNumber product = new ComplexNumber(1, 0);
        for (ComplexNumber number : numbers) {
            product = product.multiply(number);
        }
        return product;
    }

    public static void main(String[] args) {
        ComplexNumber[] complexArray = {
            new ComplexNumber(1, 2),
            new ComplexNumber(3, 4),
            new ComplexNumber(5, 6)
        };

        System.out.println("Complex numbers:");
        for (ComplexNumber cn : complexArray) {
            System.out.println(cn);
        }

        ComplexNumber product = ComplexNumber.multiplyArray(complexArray);
        System.out.println("Product of all complex numbers: " + product);
    }
}
