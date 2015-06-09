
/**
 * SmsPortCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */

    package com.microsoft.support;

    /**
     *  SmsPortCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SmsPortCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SmsPortCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SmsPortCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for SendSmsEx method
            * override this method for handling normal response from SendSmsEx operation
            */
           public void receiveResultSendSmsEx(
                    com.microsoft.support.SmsPortStub.SendSmsExResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from SendSmsEx operation
           */
            public void receiveErrorSendSmsEx(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for SendSmsAT method
            * override this method for handling normal response from SendSmsAT operation
            */
           public void receiveResultSendSmsAT(
                    com.microsoft.support.SmsPortStub.SendSmsATResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from SendSmsAT operation
           */
            public void receiveErrorSendSmsAT(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for User_Mo method
            * override this method for handling normal response from User_Mo operation
            */
           public void receiveResultUser_Mo(
                    com.microsoft.support.SmsPortStub.User_MoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from User_Mo operation
           */
            public void receiveErrorUser_Mo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for User_Overage method
            * override this method for handling normal response from User_Overage operation
            */
           public void receiveResultUser_Overage(
                    com.microsoft.support.SmsPortStub.User_OverageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from User_Overage operation
           */
            public void receiveErrorUser_Overage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for SendSms method
            * override this method for handling normal response from SendSms operation
            */
           public void receiveResultSendSms(
                    com.microsoft.support.SmsPortStub.SendSmsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from SendSms operation
           */
            public void receiveErrorSendSms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for ChkBadWord method
            * override this method for handling normal response from ChkBadWord operation
            */
           public void receiveResultChkBadWord(
                    com.microsoft.support.SmsPortStub.ChkBadWordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from ChkBadWord operation
           */
            public void receiveErrorChkBadWord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for SendAT method
            * override this method for handling normal response from SendAT operation
            */
           public void receiveResultSendAT(
                    com.microsoft.support.SmsPortStub.SendATResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from SendAT operation
           */
            public void receiveErrorSendAT(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for Send method
            * override this method for handling normal response from Send operation
            */
           public void receiveResultSend(
                    com.microsoft.support.SmsPortStub.SendResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from Send operation
           */
            public void receiveErrorSend(java.lang.Exception e) {
            }
                


    }
    