public class ComplexNumber {
    private double realPart;
    private double imagePart;
    private boolean error = false;
    private String errMsg = "";

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public ComplexNumber(double realPart, double imagePart) {
        this.realPart = realPart;
        this.imagePart = imagePart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImagePart() {
        return imagePart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImagePart(double imagePart) {
        this.imagePart = imagePart;
    }

    ComplexNumber mul (ComplexNumber a) {// умножить комплексные числа
        double real2 = a.getRealPart();
        double image2 = a.getImagePart();
        double newReal = realPart * real2 - imagePart * image2;
        double newImage = imagePart * real2 + realPart * image2;
        return new ComplexNumber(newReal, newImage);
    }

    public String  printComplexNumber(ComplexNumber f, ComplexNumber s){

        return "Result: " + f.realPart + " + " + f.imagePart + "i * " +
                s.realPart + " + " + s.imagePart + "i = " +
                this.realPart + " + " + this.imagePart + "i";
    }
}
