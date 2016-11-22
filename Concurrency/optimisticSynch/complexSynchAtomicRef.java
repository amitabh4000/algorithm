package Concurrency.optimisticSynch;
import java.util.concurrent.atomic.AtomicReference;
public class complexSynchAtomicRef {

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

        protected AtomicReference<complex> v;
        void scale(double x){
            boolean success = false;
            do{
                complex old = v.get();
                complex newComplex = new complex(x*old.real,x*old.imag);
                success = v.compareAndSet(old , newComplex);
            }
            while(!success);
        }

}
