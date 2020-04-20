package taxlogic;

public abstract class FilingStatus implements Taxable {
	double [] TaxBracketAmount = new double[7];
		
	double [] TaxBracketRate = new double[7];

	@Override
	public double calculateTax(double income) {
		TaxBracketRate[0] = 10.00;
		TaxBracketRate[1] = 12.00;
		TaxBracketRate[2] = 22.00;
		TaxBracketRate[3] = 24.00;
		TaxBracketRate[4] = 32.00;
		TaxBracketRate[5] = 35.00;
		TaxBracketRate[6] = 37.00;
		
		double totalTaxPayable = 0.0;

		double []incomeBucket = new double[7];
		incomeBucket[0]=0.0;
		incomeBucket[1]=0.0;
		incomeBucket[2]=0.0;
		incomeBucket[3]=0.0;
		incomeBucket[4]=0.0;
		incomeBucket[5]=0.0;
		incomeBucket[6]=0.0;
		
		for(int i=6; i>=0;i--) {
			if(income>TaxBracketAmount[i]) {
				incomeBucket[i] = income -TaxBracketAmount[i];
				income = income - incomeBucket[i];
			}
			//System.out.println(incomeBucket[i]);

		}
		
		for(int i=0; i<7; i++) {
			double tax = 0;
			if(incomeBucket[i]>0) {
				tax = incomeBucket[i] * TaxBracketRate[i]/100;
				totalTaxPayable = totalTaxPayable + tax;
				System.out.println("tax " + TaxBracketRate[i] + "% : of $" + incomeBucket[i] + " is $" +tax);
				
			}
		}
			
	
		
		return totalTaxPayable;
	}

}
