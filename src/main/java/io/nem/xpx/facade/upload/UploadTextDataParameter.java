package io.nem.xpx.facade.upload;

import io.nem.xpx.builder.steps.*;

import java.io.Serializable;



/**
 * The Class UploadTextDataParameter.
 */
public class UploadTextDataParameter extends AbstractUploadParameter implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The data. */
    private String data;
    
    /** The encoding. */
    private String encoding;

    /**
     * Gets the data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Gets the encoding.
     *
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Sets the encoding.
     *
     * @param encoding the new encoding
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Creates the.
     *
     * @return the sender private key step
     */
    public static SenderPrivateKeyStep<ReceiverPublicKeyStep<TextDataStep<FinalBuildSteps>>> create() {
        return new Builder();
    }

    /**
     * The Interface FinalBuildSteps.
     */
    public interface FinalBuildSteps extends
            NameStep<FinalBuildSteps>,
            EncodingStep<FinalBuildSteps>,
            ContentTypeStep<FinalBuildSteps>,
            CommonUploadBuildSteps<FinalBuildSteps> {

        /**
         * Builds the.
         *
         * @return the upload text data parameter
         */
        UploadTextDataParameter build();
    }

    /**
     * The Class Builder.
     */
    public static class Builder
            extends AbstractUploadParameterBuilder<TextDataStep, FinalBuildSteps>
            implements TextDataStep, FinalBuildSteps {

        /** The instance. */
        protected UploadTextDataParameter instance;

        /**
         * Instantiates a new builder.
         */
        private Builder() {
            super(new UploadTextDataParameter());
            this.instance = (UploadTextDataParameter) super.instance;
        }

        /**
         * Instantiates a new builder.
         *
         * @param instance the instance
         */
        protected Builder(UploadTextDataParameter instance) {
            super(instance);
            this.instance = instance;
        }

        /* (non-Javadoc)
         * @see io.nem.xpx.builder.steps.TextDataStep#data(java.lang.String)
         */
        @Override
        public FinalBuildSteps data(String data) {
            this.instance.setData(data);
            return this;
        }

        /* (non-Javadoc)
         * @see io.nem.xpx.builder.steps.ContentTypeStep#contentType(java.lang.String)
         */
        @Override
        public FinalBuildSteps contentType(String contentType) {
            this.instance.setContentType(contentType);
            return this;
        }

        /* (non-Javadoc)
         * @see io.nem.xpx.builder.steps.EncodingStep#encoding(java.lang.String)
         */
        @Override
        public FinalBuildSteps encoding(String encoding) {
            this.instance.setEncoding(encoding);
            return this;
        }

        /* (non-Javadoc)
         * @see io.nem.xpx.builder.steps.NameStep#name(java.lang.String)
         */
        @Override
        public FinalBuildSteps name(String name) {
            this.instance.setName(name);
            return this;
        }

        /* (non-Javadoc)
         * @see io.nem.xpx.facade.upload.UploadTextDataParameter.FinalBuildSteps#build()
         */
        @Override
        public UploadTextDataParameter build() {
            if (instance.getEncoding() == null) {
                instance.setEncoding("UTF-8");
            }
            if (instance.getContentType() == null) {
                instance.setContentType("text/plain");
            }
            return instance;
        }
    }


}
