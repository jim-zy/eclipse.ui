/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jface.text;


/**
 * Description of the state of document rewrite sessions.
 * <p>
 * This class is not yet for public use. API under construction.
 * 
 * @see org.eclipse.jface.text.IDocument
 * @see org.eclipse.jface.text.IDocumentExtension4
 * @see org.eclipse.jface.text.IDocumentRewriteSessionListener
 * @since 3.1
 */
public class DocumentRewriteSessionEvent {
	
	public final static Object SESSION_START= new Object();
	public final static Object SESSION_STOP= new Object();
	
	/** The changed document */
	public IDocument fDocument;
	/** The session id */
	public Object fSessionId;
	/** The change type */
	public Object fChangeType;
	
	/**
	 * Creates a new document event.
	 *
	 * @param doc the changed document
	 * @param sessionId the session id
	 * @param isStartEvent <code>true</code> if this event is a start event, <code>false</code> otherwise
	 */
	public DocumentRewriteSessionEvent(IDocument doc, Object sessionId, boolean isStartEvent) {
		Assert.isNotNull(doc);
		Assert.isNotNull(sessionId);
		
		fDocument= doc;
		fSessionId= sessionId;
		fChangeType= isStartEvent ? SESSION_START : SESSION_STOP;
	}
	
	/**
	 * Returns the changed document.
	 *
	 * @return the changed document
	 */
	public IDocument getDocument() {
		return fDocument;
	}

	/**
	 * Returns the change type of this event. This is {@link #START_STOP}.
	 * 
	 * @return the change type of this event
	 */
	public Object getChangeType() {
		return fChangeType;
	}
	
	/**
	 * Returns the id of the rewrite session.
	 * 
	 * @return the offset of the change
	 */
	public Object getSessionId() {
		return fSessionId;
	}			
}
