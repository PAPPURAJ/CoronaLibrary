To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.PAPPURAJBTC:CoronaLibrary:1.0.1'
	}






Now you can access data by using simple code

        Corona.getReport(new MyResultInterface() {
            @Override
            public void Success(Report report) {
                if(report.isSuccess())
                for(int i=0;i<report.getArrayList().size();i++)
                    Log.e("====Report===",report.getArrayList().get(i).getCountryName()+", Total Case: "+report.getArrayList().get(i).getTotalCase());
            }

            @Override
            public void failed(String errorMessage) {

            }
        });
