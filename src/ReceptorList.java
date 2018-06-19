public class ReceptorList {
    private Conceptor conceptor;

    public ReceptorList(Conceptor conceptor) {
        this.conceptor = conceptor;
    }

    public void setConceptor(Conceptor conceptor) {
        this.conceptor = conceptor;
    }

    public String[] getConceptorReceptors() {
        return this.conceptor.getReceptorsStr().toArray(new String[0]);
    }
}
