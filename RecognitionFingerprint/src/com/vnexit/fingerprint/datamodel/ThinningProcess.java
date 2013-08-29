package com.vnexit.fingerprint.datamodel;

public class ThinningProcess {
	public ThinningProcess(){
		
	}
	public Pixel[][] thinning(Pixel[][] pi){
		for(int i=1;i<pi.length-1;i++){
			System.out.print("\n");
			for(int j=1;j<pi[0].length-1;j++){
				System.out.print(pi[i][j].mBlue+" ");
				if(bien(pi, i, j) && xoa(pi, i, j)){
					Pixel p=new Pixel(255,255,255);
					pi[i][j]=p;
				}
					
			}
		}
		return pi;
	}
	public boolean deletePi(Pixel[][] pi, int i, int j){
		if(i<1||j<1){
			return false;
		}else{
			int p[]=new int[10];
			p[2]=pi[i-1][j].mBlue;
			p[3]=pi[i-1][j+1].mBlue;
			p[4]=pi[i][j+1].mBlue;
			p[5]=pi[i+1][j+1].mBlue;
			p[6]=pi[i+1][j].mBlue;
			p[7]=pi[i+1][j-1].mBlue;
			p[8]=pi[i][j-1].mBlue;
			p[9]=pi[i-1][j-1].mBlue;
			int s=p[9];
			int a=0;
			for(int k=2;k<9;k++){
				s += p[k];
				if(p[k]<p[k+1]) a++;
			}
			if(p[9]<p[2]) a++;
			if( (s>=2*255 && s<=6*255) && a==1){
				if((p[2]*p[4]*p[6])==0 || (p[2]*p[4]*p[8])==0){
					if((p[2]*p[6]*p[8])==0 || (p[4]*p[6]*p[8])==0){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	}
	
    boolean bien(Pixel[][] pi, int x, int y) {
        boolean t = false;
        if ((pi[x][y].mBlue == 0) && ((pi[x - 1][y].mBlue == 255) || (pi[x + 1][y].mBlue == 255) || (pi[x][y - 1].mBlue == 255) || (pi[x][y + 1].mBlue == 255))) {
            return t = true;
        }
        return t;
    }
    boolean xoa(Pixel[][] pi,int x, int y) {
        boolean t = false;
        if (((pi[x - 1][y - 1].mBlue == pi[x][y - 1].mBlue) && (pi[x][y - 1].mBlue == pi[x + 1][y - 1].mBlue)) && ((pi[x - 1][y + 1].mBlue == pi[x][y + 1].mBlue) && (pi[x][y + 1].mBlue == pi[x + 1][y + 1].mBlue)) && (pi[x + 1][y + 1].mBlue != pi[x - 1][y - 1].mBlue)) {
            t = true;
        }
        if (((pi[x - 1][y - 1].mBlue == pi[x - 1][y].mBlue) && (pi[x - 1][y - 1].mBlue == pi[x][y - 1].mBlue)) && ((pi[x + 1][y + 1].mBlue == pi[x][y + 1].mBlue) && (pi[x + 1][y].mBlue == pi[x + 1][y + 1].mBlue)) && (pi[x + 1][y + 1].mBlue != pi[x - 1][y - 1].mBlue)) {
            t = true;
        }
        if (((pi[x + 1][y - 1].mBlue == pi[x][y - 1].mBlue) && (pi[x + 1][y - 1].mBlue == pi[x + 1][y].mBlue)) && ((pi[x - 1][y + 1].mBlue == pi[x - 1][y].mBlue) && (pi[x - 1][y + 1].mBlue == pi[x][y + 1].mBlue)) && (pi[x - 1][y + 1].mBlue != pi[x + 1][y - 1].mBlue)) {
            t = true;
        }
        return t;
    }
    public Pixel[][] donsach(Pixel[][] pi) {
    	for(int i=1;i<pi.length-1;i++){
			for(int j=1;j<pi[0].length-1;j++){
                if (pi[i][j].mBlue == 0) {
                    if (pi[i - 1][j - 1].mBlue == 0) {
                        Pixel p = new Pixel(255, 255, 255);
                        pi[i][j - 1] = p;
                        pi[i - 1][j] = p;
                    }
                    if (pi[i + 1][j + 1].mBlue == 0) {
                        Pixel p = new Pixel(255, 255, 255);
                        pi[i][j + 1] = p;
                        pi[i + 1][j] = p;
                    }
                    if (pi[i - 1][j + 1].mBlue == 0) {
                        Pixel p = new Pixel(255, 255, 255);
                        pi[i - 1][j] = p;
                        pi[i][j + 1] = p;
                    }
                    if (pi[i + 1][j - 1].mBlue == 0) {
                        Pixel p = new Pixel(255, 255, 255);
                        pi[i][j - 1] = p;
                        pi[i + 1][j] = p;
                    }
                }
            }
        }
        return pi;
    }
}
