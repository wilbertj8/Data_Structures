import java.util.LinkedList;

public class Polynomial {
	private LinkedList<Term> terms;

	// default constructor initializes LinkedList of terms
	public Polynomial() {
		terms = new LinkedList<Term>();
	}

	// constructor that takes in first term
	public Polynomial(Term t) {
		terms = new LinkedList<Term>();
		terms.add(t);
	}

	public void add(Term t) {
		// add term to LinkedList
		terms.add(t);
	}

	public void simplify() {
		// sort terms in decreasing order of power
		insertionSort();
		// adds like terms
		combineLikeTerms();
	}

	private void combineLikeTerms() {
		for (int i = 1; i < terms.size(); i++) {
			// if two terms have same power, add coefficients
			if (terms.get(i - 1).getPower() == terms.get(i).getPower()) {
				terms.get(i - 1).setCoefficient(terms.get(i - 1).getCoefficient() + terms.remove(i).getCoefficient());
				i--;
			}
		}
	}

	public void insertionSort() {
		int j; // the number of items sorted so far
		Term key; // the item to be inserted
		int i;

		for (j = 1; j < terms.size(); j++) // Start with 1 (not 0)
		{
			key = terms.get(j);
			for (i = j - 1; (i >= 0) && (terms.get(i).getPower() < key.getPower()); i--) // Smaller values are moving up
			{
				terms.set(i + 1, terms.get(i));
			}
			terms.set(i + 1, key); // Put the key in its proper location
		}
	}

	public Polynomial add(Polynomial p) {
		Polynomial sum = new Polynomial();
		// add both sets of terms to one combined LinkedList
		for (int i = 0; i < terms.size() + p.terms.size(); i++) {
			if (i < terms.size())
				sum.add(terms.get(i));
			else
				sum.add(p.terms.get(i - terms.size()));
		}
		// simplify combined terms
		sum.simplify();
		return sum;
	}

	public Polynomial multiply(Polynomial p) {
		Polynomial products = new Polynomial();
		for (int i = 0; i < p.terms.size(); i++) {
			for (int j = 0; j < terms.size(); j++)
				// multiply each term in first by each term in second
				products.add(new Term(p.terms.get(i).getCoefficient() * terms.get(j).getCoefficient(),
						p.terms.get(i).getPower() + terms.get(j).getPower()));
			// add each product to a combined LinkedList
		}
		// simplify terms to lower terms
		products.simplify();
		return products;
	}

	public void print() {
		for (int i = 0; i < terms.size(); i++) {
			// print coefficient
			if (terms.get(i).getCoefficient() != 1)
				System.out.print(terms.get(i).getCoefficient());
			// print power if power > 1
			if (terms.get(i).getPower() > 1)
				System.out.print("x^" + terms.get(i).getPower());
			// don't print power if power == 1 (that's just x)
			else if (terms.get(i).getPower() == 1)
				System.out.print("x");
			// don't print x if power == 0 (x=1)
			if (i < terms.size() - 1)
				System.out.print("+");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Polynomial p = new Polynomial(new Term(1, 2));
		p.add(new Term(5, 0));
		p.add(new Term(3, 1));
		p.add(new Term(3, 1));
		p.add(new Term(10, 0));
		p.simplify();
		p.print();

		Polynomial p1 = new Polynomial(new Term(1, 2));
		p1.add(new Term(5, 0));
		p1.add(new Term(2, 5));
		p1.add(new Term(7, 6));
		p1.add(new Term(10, 0));
		p1.simplify();
		p1.print();

		//Polynomial sum = p.add(p1);
		//sum.print();

		Polynomial product = p.multiply(p1);
		product.print();
	}
}
