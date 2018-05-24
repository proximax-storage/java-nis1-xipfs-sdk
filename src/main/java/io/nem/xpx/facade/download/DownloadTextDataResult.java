/*
 * 
 */
package io.nem.xpx.facade.download;

import io.nem.xpx.model.NemMessageType;
import io.nem.xpx.service.model.buffers.ResourceHashMessage;

import java.nio.charset.Charset;


public class DownloadTextDataResult extends DownloadResult {

	private DownloadTextDataResult(final ResourceHashMessage dataMessage, final byte[] data, final NemMessageType messageType) {
		super(dataMessage, data, messageType);
	}

	public static DownloadTextDataResult fromDownloadResult(DownloadResult downloadResult) {
		return new DownloadTextDataResult(downloadResult.getDataMessage(),
				downloadResult.getData(),
				downloadResult.getMessageType());

	}

	public String getString(String encoding) {
		return new String(getData(), Charset.forName(encoding));
	}

	public String getString() {
		return new String(getData(), Charset.forName("UTF-8"));
	}

}
