/**
 * Copyright (c) 2018, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.vindell.wkhtmltopdf.invoker.request;


import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.github.vindell.wkhtmltopdf.invoker.InvocationOutputHandler;

/**
 * Specifies the parameters used to control a wkhtmltopdf invocation.
 */
public interface InvocationRequest {

	/**
	 * Indicates whether the environment variables of the current process should be
	 * propagated to the Maven invocation. By default, the current environment
	 * variables are inherited by the new Maven invocation.
	 * 
	 * @return <code>true</code> if the environment variables should be propagated,
	 *         <code>false</code> otherwise.
	 */
	boolean isShellEnvironmentInherited();

	/**
	 * Gets the handler used to capture the standard output from the wkhtmltopdf build.
	 * 
	 * @return The output handler or <code>null</code> if not set.
	 */
	InvocationOutputHandler getOutputHandler(InvocationOutputHandler defaultHandler);

	/**
	 * Gets the handler used to capture the error output from the wkhtmltopdf build.
	 * 
	 * @return The error handler or <code>null</code> if not set.
	 */
	InvocationOutputHandler getErrorHandler(InvocationOutputHandler defaultHandler);

	/**
	 * Gets the path to the base directory of the wkhtmltopdf installation used to run
	 * wkhtmltopdf.
	 * 
	 * @return The path to the base directory of the wkhtmltopdf installation used to
	 *         run wkhtmltopdf or <code>null</code> to use the default wkhtmltopdf home.
	 */
	File getWkhtmltopdfHome();

	/**
	 * Gets the system properties for the wkhtmltopdf invocation.
	 * 
	 * @return The system properties for the wkhtmltopdf invocation or <code>null</code>
	 *         if not set.
	 */
	Properties getProperties();

	/**
	 * Gets the goals for the wkhtmltopdf invocation.
	 * 
	 * @return The goals for the wkhtmltopdf invocation or <code>null</code> if not set.
	 */
	List<String> getGoals();

	/**
	 * Gets the environment variables for the wkhtmltopdf invocation.
	 * @return The environment variables for the wkhtmltopdf invocation or <code>null</code> if not set.
	 */
	Map<String, String> getShellEnvironments();

	// ----------------------------------------------------------------------
	//
	// ----------------------------------------------------------------------

	/**
	 * Sets the handler used to capture the standard output from the wkhtmltopdf build.
	 * @param outputHandler The output handler, may be <code>null</code> if the output is not of interest.
	 * @return This invocation request.
	 */
	InvocationRequest setOutputHandler(InvocationOutputHandler outputHandler);

	/**
	 * Sets the handler used to capture the error output from the wkhtmltopdf build.
	 * 
	 * @param errorHandler The error handler, may be <code>null</code> if the output is not of interest.
	 * @return This invocation request.
	 */
	InvocationRequest setErrorHandler(InvocationOutputHandler errorHandler);

	/**
	 * Sets the path to the base directory of the wkhtmltopdf installation used to run wkhtmltopdf.
	 * 
	 * @param wkhtmltopdfHome The path to the base directory of the wkhtmltopdf installation used to
	 *            run wkhtmltopdf, may be <code>null</code> to use the default wkhtmltopdf home.
	 * @return This invocation request.
	 */
	InvocationRequest setWkhtmltopdfHome(File wkhtmltopdfHome);

	/**
	 * Sets the system properties for the wkhtmltopdf invocation.
	 * @param properties The system properties for the wkhtmltopdf invocation, may be <code>null</code> if not set.
	 * @return This invocation request.
	 */
	InvocationRequest setProperties(Properties properties);

	/**
	 * Sets the goals for the wkhtmltopdf invocation.
	 * @param goals The goals for the wkhtmltopdf invocation 
	 * @return This invocation request.
	 */
	InvocationRequest setGoals(List<String> goals);

	/**
	 * Specifies whether the environment variables of the current process should be
	 * propagated to the wkhtmltopdf invocation.
	 * 
	 * @param shellEnvironmentInherited
	 *            <code>true</code> if the environment variables should be
	 *            propagated, <code>false</code> otherwise.
	 * @return This invocation request.
	 */
	InvocationRequest setShellEnvironmentInherited(boolean shellEnvironmentInherited);

	/**
	 * Adds the specified environment variable to the wkhtmltopdf invocation.
	 * 
	 * @param name The name of the environment variable, must not be <code>null</code>.
	 * @param value The value of the environment variable, must not be <code>null</code>.
	 * @return This invocation request.
	 */
	InvocationRequest addShellEnvironment(String name, String value);
	
	InvocationRequest setOutputFile(File outputFile);

}
