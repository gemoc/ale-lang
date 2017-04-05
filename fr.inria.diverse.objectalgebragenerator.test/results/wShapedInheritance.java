package a.algebra;

import a.AClass;
import a.BClass;
import a.XClass;
import a.YClass;
import a.ZClass;

public interface AAlgebra<AClassT,BClassT,XClassT,YClassT,ZClassT> {
	AClassT aClass(final AClass aClass);
	
	BClassT bClass(final BClass bClass);
	
	XClassT xClass(final XClass xClass);
	AClassT aClass_xClass(final XClass xClass);
	
	YClassT yClass(final YClass yClass);
	AClassT aClass_yClass(final YClass yClass);
	BClassT bClass_yClass(final YClass yClass);
	
	ZClassT zClass(final ZClass zClass);
	BClassT bClass_zClass(final ZClass zClass);
	
	
	default AClassT $(final AClass aClass) {
		AClassT ret = null;
		if(aClass instanceof YClass) {
			ret = aClass_yClass((YClass) aClass);
		}
		if(aClass instanceof XClass) {
			ret = aClass_xClass((XClass) aClass);
		}
		
		if(ret == null) ret = aClass(aClass);
		return ret;
	}
	
	default BClassT $(final BClass bClass) {
		BClassT ret = null;
		if(bClass instanceof ZClass) {
			ret = bClass_zClass((ZClass) bClass);
		}
		if (bClass instanceof YClass) {
			ret = bClass_yClass((YClass) bClass);
		}
		
		if(ret == null) ret = bClass(bClass);
		return ret;
	}
	
	default XClassT $(final XClass xClass) {
		XClassT ret = null;
		
		if(ret == null) ret = xClass(xClass);
		return ret;
	}
	
	default ZClassT $(final ZClass zClass) {
		ZClassT ret = null;
		
		if(ret == null) ret = zClass(zClass);
		return ret;
	}
	
	default YClassT $(final YClass yClass) {
		YClassT ret = null;
		
		if(ret == null) ret = yClass(yClass);
		return ret;
	}

}
