# northwesternmutual-test
Selenium Maven automated regression/integration test project.

## Overview
Maven Selenium WebDriver Java project using JUnit testing framework.
This project is a Page Object Design pattern. Test data such as login credentials and URLs can be derived from the environment properties. 
Test project separated into three packages: helper, page, test

helpers:
- DriverUtils: includes common static helpers to support load driver.
- PageHelper: all helper methods for pages to inherit.
- TestHelper: includes test helpers such as test driver loads, verify/assert with error collector, data setups, etc.

pages: Contains Page objects. All UI pages should be page objects.

tests: Contains all test classes.

resources: Environment-specific test data such as URL, credentials.

#### How To Run The Test
- Simply right-click on the tests package to run all tests under the package, test class name to run all tests under a test class, or on a test method name to simply run only a test.
- Or using maven command with test suit profile: ````mvn clean test -Pui-regression-tests````

##### How To Add New Test
- Add test method in 'tests' package with new test class or in existing test class.
- New test class should inherit TestHelper.
- Test class should not have any page elements.
- All page elements locator should in page class.
- All common helpers in the steps such as set field, click/submit, get status text, etc should be in the page object for the UI inherited from the PageHelper.
- Add all test step(s) in page object and test should instantiate the page object and call the steps from the page object and test should assert.
- Any helper methods that interact with a UI page should be in the PageHelper class.

##### Note
- Minimize number assert pert tests.
- Split tests for specific verification.
