package lang;
//package lang;
//
//public class ImplementationInterpreter {
//	
//	JavaExtensionsManager javaExtensions;
//	
//	private final ClassLoadingCallback callback = new ClassLoadingCallback() {
//
//        @Override
//        public void loaded(String qualifiedName, Class<?> clazz) {
//            ServiceUtils.registerServices(queryEnvironment, ServiceUtils.getServices(queryEnvironment, clazz));
//        }
//
//        @Override
//        public void notFound(String qualifiedName) {
//            AQLSiriusPlugin.INSTANCE.log(new Status(IStatus.WARNING, AQLSiriusPlugin.INSTANCE.getSymbolicName(), MessageFormat.format(Messages.AQLInterpreter_javaClassNotFound, qualifiedName)));
//        }
//
//        @Override
//        public void unloaded(String qualifiedName, Class<?> clazz) {
//            ServiceUtils.removeServices(queryEnvironment, ServiceUtils.getServices(queryEnvironment, clazz));
//        }
//    };
//    
//    public ImplementationInterpreter() {
//        this.queryEnvironment = Query.newEnvironmentWithDefaultServices(xRef);
//        this.ePackageCallBack = new EPackageLoadingCallback() {
//
//            @Override
//            public void loaded(String nsURI, EPackage pak) {
//                queryEnvironment.registerEPackage(pak);
//            }
//
//            @Override
//            public void unloaded(String nsURI, EPackage pak) {
//                queryEnvironment.removeEPackage(pak.getName());
//            }
//        };
//        this.javaExtensions.addClassLoadingCallBack(callback);
//        this.javaExtensions.addEPackageCallBack(ePackageCallBack);
//        this.queryEnvironment.registerEPackage(EcorePackage.eINSTANCE);
//	}
//}
