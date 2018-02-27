/*
 * 
 */
package io.nem.xpx.wrap;

import java.util.List;

import org.nem.core.crypto.CryptoEngine;
import org.nem.core.crypto.CryptoEngines;
import org.nem.core.crypto.Hash;
import org.nem.core.crypto.KeyPair;
import org.nem.core.crypto.PublicKey;
import org.nem.core.model.Account;
import org.nem.core.model.MultisigSignatureTransaction;

import io.nem.ApiException;
import io.nem.builder.MultisigSignatureTransactionBuilder;

/**
 * The Class MultisigCoSign.
 */
public class MultisigCoSign {

	/** The peer connection. */
	private PeerConnection peerConnection;
	
	/** The engine. */
	private CryptoEngine engine;

	/**
	 * Instantiates a new multisig co sign.
	 *
	 * @param peerConnection the peer connection
	 */
	public MultisigCoSign(PeerConnection peerConnection) {
		this.peerConnection = peerConnection;
		this.engine = CryptoEngines.ed25519Engine();
	}

	/**
	 * Co sign.
	 *
	 * @param nemHash the nem hash
	 * @param multisigAccount the multisig account
	 * @param signers the signers
	 * @return the multisig signature transaction
	 * @throws ApiException the api exception
	 */
	public MultisigSignatureTransaction coSign(String nemHash, String multisigAccount, List<Account> signers)
			throws ApiException {

		MultisigSignatureTransaction multisigSignatureTransaction = MultisigSignatureTransactionBuilder
				.multisig(new Account(new KeyPair(PublicKey.fromHexString(multisigAccount)))) // multisig
				.addSigners(signers).otherTransaction(Hash.fromHexString(nemHash)).coSign();

		return multisigSignatureTransaction;

	}

}