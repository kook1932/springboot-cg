package com.does.springbootcg.biz.domain.exception;

import lombok.Getter;

public class Constants {

	@Getter
	public enum ExceptionClass {
		PRODUCT("Product");
		private String exceptionClass;

		ExceptionClass(String exceptionClass) {
			this.exceptionClass = exceptionClass;
		}

		@Override
		public String toString() {
			return getExceptionClass() + " Exception.";
		}
	}
}
