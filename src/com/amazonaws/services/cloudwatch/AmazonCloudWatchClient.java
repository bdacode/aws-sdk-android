/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.cloudwatch;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.StandardErrorUnmarshaller;

import com.amazonaws.services.cloudwatch.model.*;
import com.amazonaws.services.cloudwatch.model.transform.*;


/**
 * Client for accessing AmazonCloudWatch.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * Amazon CloudWatch <p>
 * This is the <i>Amazon CloudWatch API Reference</i> . This guide provides detailed information about Amazon CloudWatch actions, data types, parameters,
 * and errors. For detailed information about Amazon CloudWatch features and their associated API calls, go to the <a
 * href="http://docs.amazonwebservices.com/AmazonCloudWatch/latest/DeveloperGuide"> Amazon CloudWatch Developer Guide </a> .
 * </p>
 * <p>
 * Amazon CloudWatch is a web service that enables you to publish, monitor, and manage various metrics, as well as configure alarm actions based on data
 * from metrics. For more information about this product go to <a href="http://aws.amazon.com/cloudwatch"> http://aws.amazon.com/cloudwatch </a> .
 * </p>
 * <p>
 * Use the following links to get started using the <i>Amazon CloudWatch API Reference</i> :
 * </p>
 * 
 * <ul>
 * <li> <a href="http://docs.amazonwebservices.com/AmazonCloudWatch/latest/APIReference/API_Operations.html"> Actions </a> : An alphabetical list of all
 * Amazon CloudWatch actions.</li>
 * <li> <a href="http://docs.amazonwebservices.com/AmazonCloudWatch/latest/APIReference/API_Types.html"> Data Types </a> : An alphabetical list of all
 * Amazon CloudWatch data types.</li>
 * <li> <a href="http://docs.amazonwebservices.com/AmazonCloudWatch/latest/APIReference/CommonParameters.html"> Common Parameters </a> : Parameters that
 * all Query actions can use.</li>
 * <li> <a href="http://docs.amazonwebservices.com/AmazonCloudWatch/latest/APIReference/CommonErrors.html"> Common Errors </a> : Client and server
 * errors that all actions can return.</li>
 * <li> <a href="http://docs.amazonwebservices.com/general/latest/gr/index.html?rande.html"> Regions and Endpoints </a> : Itemized regions and endpoints
 * for all AWS products.</li>
 * <li> <a href="http://monitoring.amazonaws.com/doc/2010-08-01/CloudWatch.wsdl"> WSDL Location </a> :
 * http://monitoring.amazonaws.com/doc/2010-08-01/CloudWatch.wsdl</li>
 * 
 * </ul>
 */
public class AmazonCloudWatchClient extends AmazonWebServiceClient implements AmazonCloudWatch {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonCloudWatch exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    
    /** AWS signer for authenticating requests. */
    private AWS4Signer signer;


    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudWatch.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProvider
     */
    public AmazonCloudWatchClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudWatch.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonCloudWatch
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProvider
     */
    public AmazonCloudWatchClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudWatch using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonCloudWatchClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudWatch using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonCloudWatch
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonCloudWatchClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudWatch using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonCloudWatchClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonCloudWatch using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonCloudWatch
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonCloudWatchClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new InvalidNextTokenExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidParameterCombinationExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidFormatExceptionUnmarshaller());
        exceptionUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InternalServiceExceptionUnmarshaller());
        exceptionUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        exceptionUnmarshallers.add(new MissingRequiredParameterExceptionUnmarshaller());
        exceptionUnmarshallers.add(new InvalidParameterValueExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("monitoring.amazonaws.com");

        signer = new AWS4Signer();
        
        signer.setServiceName("monitoring");
        

        HandlerChainFactory chainFactory = new HandlerChainFactory();
		requestHandlers.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/cloudwatch/request.handlers"));
    }

    
    /**
     * <p>
     * Creates or updates an alarm and associates it with the specified
     * Amazon CloudWatch metric. Optionally, this operation can associate one
     * or more Amazon Simple Notification Service resources with the alarm.
     * </p>
     * <p>
     * When this operation creates an alarm, the alarm state is immediately
     * set to <code>INSUFFICIENT_DATA</code> . The alarm is evaluated and
     * its <code>StateValue</code> is set appropriately. Any actions
     * associated with the <code>StateValue</code> is then executed.
     * </p>
     * <p>
     * <b>NOTE:</b> When updating an existing alarm, its StateValue is left
     * unchanged.
     * </p>
     *
     * @param putMetricAlarmRequest Container for the necessary parameters to
     *           execute the PutMetricAlarm service method on AmazonCloudWatch.
     * 
     * @throws LimitExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void putMetricAlarm(PutMetricAlarmRequest putMetricAlarmRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<PutMetricAlarmRequest> request = new PutMetricAlarmRequestMarshaller().marshall(putMetricAlarmRequest);
        invoke(request, null);
    }
    
    /**
     * <p>
     * Publishes metric data points to Amazon CloudWatch. Amazon Cloudwatch
     * associates the data points with the specified metric. If the specified
     * metric does not exist, Amazon CloudWatch creates the metric.
     * </p>
     * <p>
     * <b>NOTE:</b> If you create a metric with the PutMetricData action,
     * allow up to fifteen minutes for the metric to appear in calls to the
     * ListMetrics action.
     * </p>
     * <p>
     * The size of a PutMetricData request is limited to 8 KB for HTTP GET
     * requests and 40 KB for HTTP POST requests.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Although the Value parameter accepts numbers of type
     * Double, Amazon CloudWatch truncates values with very large exponents.
     * Values with base-10 exponents greater than 126 (1 x 10^126) are
     * truncated. Likewise, values with base-10 exponents less than -130 (1 x
     * 10^-130) are also truncated.
     * </p>
     *
     * @param putMetricDataRequest Container for the necessary parameters to
     *           execute the PutMetricData service method on AmazonCloudWatch.
     * 
     * @throws InvalidParameterValueException
     * @throws InternalServiceException
     * @throws InvalidParameterCombinationException
     * @throws MissingRequiredParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void putMetricData(PutMetricDataRequest putMetricDataRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<PutMetricDataRequest> request = new PutMetricDataRequestMarshaller().marshall(putMetricDataRequest);
        invoke(request, null);
    }
    
    /**
     * <p>
     * Returns a list of valid metrics stored for the AWS account owner.
     * Returned metrics can be used with <code>GetMetricStatistics</code> to
     * obtain statistical data for a given metric.
     * </p>
     * <p>
     * <b>NOTE:</b> Up to 500 results are returned for any one call. To
     * retrieve further results, use returned NextToken values with
     * subsequent ListMetrics operations.
     * </p>
     * <p>
     * <b>NOTE:</b> If you create a metric with the PutMetricData action,
     * allow up to fifteen minutes for the metric to appear in calls to the
     * ListMetrics action.
     * </p>
     *
     * @param listMetricsRequest Container for the necessary parameters to
     *           execute the ListMetrics service method on AmazonCloudWatch.
     * 
     * @return The response from the ListMetrics service method, as returned
     *         by AmazonCloudWatch.
     * 
     * @throws InternalServiceException
     * @throws InvalidParameterValueException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListMetricsResult listMetrics(ListMetricsRequest listMetricsRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<ListMetricsRequest> request = new ListMetricsRequestMarshaller().marshall(listMetricsRequest);
        return invoke(request, new ListMetricsResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * Gets statistics for the specified metric.
     * </p>
     * <p>
     * <b>NOTE:</b> The maximum number of data points returned from a single
     * GetMetricStatistics request is 1,440. If a request is made that
     * generates more than 1,440 data points, Amazon CloudWatch returns an
     * error. In such a case, alter the request by narrowing the specified
     * time range or increasing the specified period. Alternatively, make
     * multiple requests across adjacent time ranges.
     * </p>
     * <p>
     * Amazon CloudWatch aggregates data points based on the length of the
     * <code>period</code> that you specify. For example, if you request
     * statistics with a one-minute granularity, Amazon CloudWatch aggregates
     * data points with time stamps that fall within the same one-minute
     * period. In such a case, the data points queried can greatly outnumber
     * the data points returned.
     * </p>
     * <p>
     * <b>NOTE:</b> The maximum number of data points that can be queried is
     * 50,850; whereas the maximum number of data points returned is 1,440.
     * </p>
     * <p>
     * The following examples show various statistics allowed by the data
     * point query maximum of 50,850 when you call
     * <code>GetMetricStatistics</code> on Amazon EC2 instances with detailed
     * (one-minute) monitoring enabled:
     * </p>
     * 
     * <ul>
     * <li>Statistics for up to 400 instances for a span of one hour</li>
     * <li>Statistics for up to 35 instances over a span of 24 hours</li>
     * <li>Statistics for up to 2 instances over a span of 2 weeks</li>
     * 
     * </ul>
     *
     * @param getMetricStatisticsRequest Container for the necessary
     *           parameters to execute the GetMetricStatistics service method on
     *           AmazonCloudWatch.
     * 
     * @return The response from the GetMetricStatistics service method, as
     *         returned by AmazonCloudWatch.
     * 
     * @throws InvalidParameterValueException
     * @throws InternalServiceException
     * @throws InvalidParameterCombinationException
     * @throws MissingRequiredParameterException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest getMetricStatisticsRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<GetMetricStatisticsRequest> request = new GetMetricStatisticsRequestMarshaller().marshall(getMetricStatisticsRequest);
        return invoke(request, new GetMetricStatisticsResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * Disables actions for the specified alarms. When an alarm's actions
     * are disabled the alarm's state may change, but none of the alarm's
     * actions will execute.
     * </p>
     *
     * @param disableAlarmActionsRequest Container for the necessary
     *           parameters to execute the DisableAlarmActions service method on
     *           AmazonCloudWatch.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void disableAlarmActions(DisableAlarmActionsRequest disableAlarmActionsRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DisableAlarmActionsRequest> request = new DisableAlarmActionsRequestMarshaller().marshall(disableAlarmActionsRequest);
        invoke(request, null);
    }
    
    /**
     * <p>
     * Retrieves alarms with the specified names. If no name is specified,
     * all alarms for the user are returned. Alarms can be retrieved by using
     * only a prefix for the alarm name, the alarm state, or a prefix for any
     * action.
     * </p>
     *
     * @param describeAlarmsRequest Container for the necessary parameters to
     *           execute the DescribeAlarms service method on AmazonCloudWatch.
     * 
     * @return The response from the DescribeAlarms service method, as
     *         returned by AmazonCloudWatch.
     * 
     * @throws InvalidNextTokenException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest describeAlarmsRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DescribeAlarmsRequest> request = new DescribeAlarmsRequestMarshaller().marshall(describeAlarmsRequest);
        return invoke(request, new DescribeAlarmsResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * Retrieves all alarms for a single metric. Specify a statistic,
     * period, or unit to filter the set of alarms further.
     * </p>
     *
     * @param describeAlarmsForMetricRequest Container for the necessary
     *           parameters to execute the DescribeAlarmsForMetric service method on
     *           AmazonCloudWatch.
     * 
     * @return The response from the DescribeAlarmsForMetric service method,
     *         as returned by AmazonCloudWatch.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DescribeAlarmsForMetricRequest> request = new DescribeAlarmsForMetricRequestMarshaller().marshall(describeAlarmsForMetricRequest);
        return invoke(request, new DescribeAlarmsForMetricResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * Retrieves history for the specified alarm. Filter alarms by date
     * range or item type. If an alarm name is not specified, Amazon
     * CloudWatch returns histories for all of the owner's alarms.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon CloudWatch retains the history of an alarm for two
     * weeks, whether or not you delete the alarm.
     * </p>
     *
     * @param describeAlarmHistoryRequest Container for the necessary
     *           parameters to execute the DescribeAlarmHistory service method on
     *           AmazonCloudWatch.
     * 
     * @return The response from the DescribeAlarmHistory service method, as
     *         returned by AmazonCloudWatch.
     * 
     * @throws InvalidNextTokenException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DescribeAlarmHistoryRequest> request = new DescribeAlarmHistoryRequestMarshaller().marshall(describeAlarmHistoryRequest);
        return invoke(request, new DescribeAlarmHistoryResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * Enables actions for the specified alarms.
     * </p>
     *
     * @param enableAlarmActionsRequest Container for the necessary
     *           parameters to execute the EnableAlarmActions service method on
     *           AmazonCloudWatch.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void enableAlarmActions(EnableAlarmActionsRequest enableAlarmActionsRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<EnableAlarmActionsRequest> request = new EnableAlarmActionsRequestMarshaller().marshall(enableAlarmActionsRequest);
        invoke(request, null);
    }
    
    /**
     * <p>
     * Deletes all specified alarms. In the event of an error, no alarms are
     * deleted.
     * </p>
     *
     * @param deleteAlarmsRequest Container for the necessary parameters to
     *           execute the DeleteAlarms service method on AmazonCloudWatch.
     * 
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteAlarms(DeleteAlarmsRequest deleteAlarmsRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<DeleteAlarmsRequest> request = new DeleteAlarmsRequestMarshaller().marshall(deleteAlarmsRequest);
        invoke(request, null);
    }
    
    /**
     * <p>
     * Temporarily sets the state of an alarm. When the updated
     * <code>StateValue</code> differs from the previous value, the action
     * configured for the appropriate state is invoked. This is not a
     * permanent change. The next periodic alarm check (in about a minute)
     * will set the alarm to its actual state.
     * </p>
     *
     * @param setAlarmStateRequest Container for the necessary parameters to
     *           execute the SetAlarmState service method on AmazonCloudWatch.
     * 
     * @throws ResourceNotFoundException
     * @throws InvalidFormatException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void setAlarmState(SetAlarmStateRequest setAlarmStateRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<SetAlarmStateRequest> request = new SetAlarmStateRequestMarshaller().marshall(setAlarmStateRequest);
        invoke(request, null);
    }
    
    /**
     * <p>
     * Returns a list of valid metrics stored for the AWS account owner.
     * Returned metrics can be used with <code>GetMetricStatistics</code> to
     * obtain statistical data for a given metric.
     * </p>
     * <p>
     * <b>NOTE:</b> Up to 500 results are returned for any one call. To
     * retrieve further results, use returned NextToken values with
     * subsequent ListMetrics operations.
     * </p>
     * <p>
     * <b>NOTE:</b> If you create a metric with the PutMetricData action,
     * allow up to fifteen minutes for the metric to appear in calls to the
     * ListMetrics action.
     * </p>
     * 
     * @return The response from the ListMetrics service method, as returned
     *         by AmazonCloudWatch.
     * 
     * @throws InternalServiceException
     * @throws InvalidParameterValueException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListMetricsResult listMetrics() throws AmazonServiceException, AmazonClientException {
        return listMetrics(new ListMetricsRequest());
    }
    
    /**
     * <p>
     * Retrieves alarms with the specified names. If no name is specified,
     * all alarms for the user are returned. Alarms can be retrieved by using
     * only a prefix for the alarm name, the alarm state, or a prefix for any
     * action.
     * </p>
     * 
     * @return The response from the DescribeAlarms service method, as
     *         returned by AmazonCloudWatch.
     * 
     * @throws InvalidNextTokenException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAlarmsResult describeAlarms() throws AmazonServiceException, AmazonClientException {
        return describeAlarms(new DescribeAlarmsRequest());
    }
    
    /**
     * <p>
     * Retrieves history for the specified alarm. Filter alarms by date
     * range or item type. If an alarm name is not specified, Amazon
     * CloudWatch returns histories for all of the owner's alarms.
     * </p>
     * <p>
     * <b>NOTE:</b> Amazon CloudWatch retains the history of an alarm for two
     * weeks, whether or not you delete the alarm.
     * </p>
     * 
     * @return The response from the DescribeAlarmHistory service method, as
     *         returned by AmazonCloudWatch.
     * 
     * @throws InvalidNextTokenException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonCloudWatch indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAlarmHistoryResult describeAlarmHistory() throws AmazonServiceException, AmazonClientException {
        return describeAlarmHistory(new DescribeAlarmHistoryRequest());
    }
    
    /**
     * Overrides the default endpoint for this client ("https://monitoring.amazonaws.com") and explicitly provides
     * an AWS region ID and AWS service name to use when the client calculates a signature
     * for requests.  In almost all cases, this region ID and service name
     * are automatically determined from the endpoint, and callers should use the simpler
     * one-argument form of setEndpoint instead of this method.
     * <p>
     * <b>This method is not threadsafe. Endpoints should be configured when the
     * client is created and before any service requests are made. Changing it
     * afterwards creates inevitable race conditions for any service requests in
     * transit.</b>
     * <p>
     * Callers can pass in just the endpoint (ex: "monitoring.amazonaws.com") or a full
     * URL, including the protocol (ex: "https://monitoring.amazonaws.com"). If the
     * protocol is not specified here, the default protocol from this client's
     * {@link ClientConfiguration} will be used, which by default is HTTPS.
     * <p>
     * For more information on using AWS regions with the AWS SDK for Java, and
     * a complete list of all available endpoints for all AWS services, see:
     * <a href="http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912">
     * http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912</a>
     *
     * @param endpoint
     *            The endpoint (ex: "monitoring.amazonaws.com") or a full URL,
     *            including the protocol (ex: "https://monitoring.amazonaws.com") of
     *            the region specific AWS endpoint this client will communicate
     *            with.
     * @param serviceName
     *            The name of the AWS service to use when signing requests.
     * @param regionId
     *            The ID of the region in which this service resides.
     *
     * @throws IllegalArgumentException
     *             If any problems are detected with the specified endpoint.
     */
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {
        setEndpoint(endpoint);
        signer.setServiceName(serviceName);
        signer.setRegionName(regionId);
    }
    

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, Unmarshaller<X, StaxUnmarshallerContext> unmarshaller) {
        request.setEndpoint(endpoint);
        for (Entry<String, String> entry : request.getOriginalRequest().copyPrivateRequestParameters().entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
        	credentials = originalRequest.getRequestCredentials();
        }

        ExecutionContext executionContext = createExecutionContext();
        executionContext.setSigner(signer);
        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return (X)client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        