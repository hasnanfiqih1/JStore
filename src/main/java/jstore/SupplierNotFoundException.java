package jstore;
public class SupplierNotFoundException extends Exception {

        private int supplier_error;

        public SupplierNotFoundException(int supplier_error){
            super("Supplier ID: ");
            this.supplier_error = supplier_error;
        }

        public String getExMessage(){
            return super.getMessage() + supplier_error + " not found.";
        }


}
