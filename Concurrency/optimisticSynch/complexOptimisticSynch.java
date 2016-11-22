package Concurrency.optimisticSynch;

public class complexOptimisticSynch {
    class complex {
        final double real;
        final double imag;

        complex(double real, double imag) {
            this.real = real;
            this.imag = imag;
        }

        public complex add(complex b) {
            return new complex(this.real + b.real, this.imag + b.imag);
        }

    }

        protected complex v;
        void scale(double x){
            boolean success = false;
            do{
                complex old = getComplex();
                complex newComplex = new complex(x*old.real,x*old.imag);
                success = commit(old,newComplex);
            }
            while(!success);
        }
        synchronized complex getComplex(){return v;}
        synchronized boolean commit(complex old, complex newComplex){
            if(old == v){
                v = newComplex;
                return true;
            }
            else{
                return false;
            }
        }
}
